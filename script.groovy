def buildApp() {
	echo 'Building the App from Groovy'
}


def testApp() {
	echo 'Testing the App from Groovy'
}


def deployApp() {
	echo 'Deploying the App from Groovy'
	echo "Deploying version: ${params.VERSION} from Groovy"
}

return this
