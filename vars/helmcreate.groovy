//Groovy file - testing shared libs approach
def call(String chartName) {
    sh "helm create ${chartName}"
    sh "helm ls"
    sh "helm upgrade --install ${chartName} ${chartName}/"
}