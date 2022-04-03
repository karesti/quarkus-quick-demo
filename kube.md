* postgres
```shell
kubectl apply -f postgres.yaml
```

* secrets
```shell
kubectl create secret generic greetingdb-credentials --from-literal=db-username=wescale --from-literal=db-password=secret
```

* Deploy to minikube
```shell
eval $(minikube -p minikube docker-env)
./mvnw clean package -Dquarkus.kubernetes.deploy=true -DskipTests=true 
```

* Scale down
```shell
export DEMO=$(minikube service --url demo)
http $DEMO/q/health 
kubectl scale --replicas=0 deployment/postgres
kubectl get pods
```

* cleanup
```shell
kubectl delete service postgres    
kubectl delete deployment postgres
kubectl delete secrets greetingdb-credentials

```

