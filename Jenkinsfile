def gv 

pipeline{
  agent any
  
  environment {
    SERVER_CREDENTIALS = credentials('CredentialsTest')
  }
  parameters {
  choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'], description: "")
  booleanParam(name: 'executeTests', defaultValue: true, description: "")
  }
  stages {
    
    stage("Init"){
      steps {
        script {
          gv = load "script.groovy"          
        }
      }
    }
    
    stage ("Build") {
      
      steps {
        
        script {
          gv.buildApp()
        }
        
        echo 'Building the application...'
        echo "Some credentials ${SERVER_CREDENTIALS}"
      }
    }
    
     stage ("Test") {
       when {
         expression {
          params.executeTests
         }
       }
      steps {
        
        script {
          gv.testApp()
        }
        
        echo 'Testing the application...'
      }
    }
    
     stage ("Deploy") {
      
      steps {
        
        echo "To execute Grovvy commands in a declarative Jenkinsfile, instead of node use script tag as below:"
        
        script {
          gv.deployApp()
        }
        
        
        echo 'Deploying the application...'
        withCredentials ([usernamePassword(credentialsId:"CredentialsTest", usernameVariable:"USER", passwordVariable:"PWD")]) {
          echo "WithCredentials USER: ${USER} PWD: ${PWD}"
          echo "Deploying version: ${params.VERSION}"
        }
      }
    }
    
    
     stage ("Clean") {
      
      steps {
        echo 'Cleaning the Jenkins Run...'
      }
    }
    
    
    
  }

}
