job('jenkins-docker-example') {
  triggers {
    cron('@daily')
  }
  steps {
    shell('docker run ghcr.io/markvr/jenkins-docker-example:a1ce99
 }
}