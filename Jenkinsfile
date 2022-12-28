pipeline{
  agent any
  
  environment {
    SERVER_CREDENTIALS = credentials('CredentialsTest')
  }
  
  stages {
    
    stage ("Build") {
      
      steps {
        echo 'Building the application...'
        echo "Some credentials ${SERVER_CREDENTIALS}"
      }
    }
    
     stage ("Test") {
      
      steps {
        echo 'Testing the application...'
      }
    }
    
     stage ("Deploy") {
      
      steps {
        echo 'Deploying the application...'
        withCredentials ([usernamePassword(credentialsId:"CredentialsTest", usernameVariable:"USER", passwordVariable:"PWD")]) {
          echo "WithCredentials USER: ${USER} PWD: ${PWD}"
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
