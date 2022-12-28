def buildApp() {
	echo 'Building the App'
}


def testApp() {
	echo 'Testing the App'
}


def deployApp() {
	echo 'Deploying the App'
	echo "Deploying version: ${params.VERSION}"
}

return this
