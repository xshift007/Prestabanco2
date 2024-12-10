Param(
    [string]$DOCKER_USER = "xsh1ft",   # Tu usuario de Docker Hub
    [string]$VERSION = "1.0",          # Versión/tag de la imagen
    [string]$NAMESPACE = "default"     # Namespace de Kubernetes
)

# Establecer que el script se detenga si hay errores
$ErrorActionPreference = "Stop"

Write-Host "Compilando proyectos con Maven..."
cmd /c "mvn clean install -DskipTests"

Write-Host "Construyendo y subiendo imágenes Docker..."
# Asegúrate de que los Dockerfile y pom.xml estén correctos
# Ajusta los paths si es necesario
docker build -t $DOCKER_USER/config-server:$VERSION ./config-server
docker push $DOCKER_USER/config-server:$VERSION

docker build -t $DOCKER_USER/eureka-server:$VERSION ./eureka-server
docker push $DOCKER_USER/eureka-server:$VERSION

docker build -t $DOCKER_USER/gateway-server:$VERSION ./gateway-server
docker push $DOCKER_USER/gateway-server:$VERSION

docker build -t $DOCKER_USER/m1-credit-simulation-service:$VERSION ./m1-credit-simulation-service
docker push $DOCKER_USER/m1-credit-simulation-service:$VERSION

docker build -t $DOCKER_USER/m2-user-registration-service:$VERSION ./m2-user-registration-service
docker push $DOCKER_USER/m2-user-registration-service:$VERSION

Write-Host "Aplicando ConfigMaps y Secrets..."
kubectl apply -f deployment/mysql-config-map.yaml -n $NAMESPACE
kubectl apply -f deployment/mysql-secrets.yaml -n $NAMESPACE

Write-Host "Desplegando Config Server..."
kubectl apply -f deployment/config-server-deployment-service.yaml -n $NAMESPACE

Write-Host "Desplegando Eureka Server..."
kubectl apply -f deployment/eureka-server-deployment-service.yaml -n $NAMESPACE

Write-Host "Desplegando Gateway Server..."
kubectl apply -f deployment/gateway-server-deployment-service.yaml -n $NAMESPACE

Write-Host "Desplegando Bases de Datos (M1 y M2)..."
kubectl apply -f deployment/m1-db-deployment-service.yaml -n $NAMESPACE
kubectl apply -f deployment/m2-db-deployment-service.yaml -n $NAMESPACE

Write-Host "Desplegando Microservicios..."
kubectl apply -f deployment/m1-credit-simulation-service-deployment-service.yaml -n $NAMESPACE
kubectl apply -f deployment/m2-user-registration-service-deployment-service.yaml -n $NAMESPACE

Write-Host "Esperando que los pods estén disponibles..."
# Opcional: esperar a que los deployments estén en estado Available.
# Estos comandos pueden fallar si los pods tardan demasiado.
# Puedes ajustar el timeout o ignorar los errores.

try {
    kubectl wait --for=condition=Available deployment/config-server-deployment -n $NAMESPACE --timeout=180s
} catch {}
try {
    kubectl wait --for=condition=Available deployment/eureka-server-deployment -n $NAMESPACE --timeout=180s
} catch {}
try {
    kubectl wait --for=condition=Available deployment/gateway-server-deployment -n $NAMESPACE --timeout=180s
} catch {}
try {
    kubectl wait --for=condition=Available deployment/m1-credit-simulation-service-deployment -n $NAMESPACE --timeout=180s
} catch {}
try {
    kubectl wait --for=condition=Available deployment/m2-user-registration-service-deployment -n $NAMESPACE --timeout=180s
} catch {}

Write-Host "Estado final de Pods:"
kubectl get pods -o wide -n $NAMESPACE

Write-Host "Estado final de Services:"
kubectl get svc -n $NAMESPACE
