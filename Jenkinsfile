pipeline {
  environment {
    PROJECT = "useful-variety-415821"
    APP_NAME = "booking-deployment"
    CLUSTER = "sofe3980u"
    CLUSTER_ZONE = "northamerica-northeast1-b"
    IMAGE_TAG = "gcr.io/${PROJECT}/${APP_NAME}"
    JENKINS_CRED = "6997199e-9a41-4f9a-bc2c-efe74d4446f3"
  }
  
agent {
        kubernetes {
            label 'sample-app'
            defaultContainer 'jnlp'
            yaml """
apiVersion: v1
kind: Pod
metadata:
    labels:
        component: ci
spec:
    # Use service account that can deploy to all namespaces
    serviceAccountName: cd-jenkins
    containers:
    - name: gcloud
      image: google/cloud-sdk:latest
      command:
      - cat
      tty: true
    - name: kubectl
      image: gcr.io/cloud-builders/kubectl
      command:
      - cat
      tty: true
"""
        }
    }
    tools {
        maven 'maven'
    }
    stages {
        stage ('Init') {
            steps {
                checkout scm
                sh 'echo "Start of Job"'
            }
        }
         stage ('test') {
            steps {
                sh 'mvn clean test -f ./pom.xml'
            }
        } 
        stage ('build') {
            steps {
                sh 'mvn package -DskipTests -f ./pom.xml'
            }
        }
        stage('Build and push image with Container Builder') {
            steps {
                withCredentials([file(credentialsId: "new", variable: 'GOOGLE_APPLICATION_CREDENTIALS')]) {
                    container('gcloud') {
                        // Now GOOGLE_APPLICATION_CREDENTIALS will have the path to the secret file
                        sh "gcloud auth activate-service-account --key-file=${GOOGLE_APPLICATION_CREDENTIALS}"
                        sh "gcloud builds submit --tag ${IMAGE_TAG} ./"
                    }
                }
            }
        }
        stage('Deploy to GKE') {
            steps {
                container('gcloud') {
                    sh("gcloud container clusters get-credentials ${CLUSTER} --zone ${CLUSTER_ZONE} --project ${PROJECT}")
                    sh "kubectl delete pods --selector=app=binarycalculator-deployment"
                    // sh("kubectl set image deployment/${APP_NAME} ${APP_NAME}=${IMAGE_TAG}")
                    // sh("kubectl set image deployment/booking-deployment ticketbookingapp=gcr.io/${PROJECT}/booking-deployment:latest")
                    sh "kubectl apply -f deployment.yaml"
                }
            }
        }
    }
}
