* Pre-requesites

  Run only once:

```bash
helm dependency build
```

After upgredes to [control-plane.conf](control-plane.conf) or [job.json](job.json): 

```bash
./gradlew preprocess
```
* Installation

```bash
kubectl delete namespace gatling-k8s-k8s
kubectl create namespace gatling-k8s-k8s
helm install k8s-k8s . -n gatling-k8s-k8s
```

* Status

``` bash
helm list 
kubectl -n gatling-k8s-k8s api-resources --verbs=list --namespaced -o name  | xargs -n 1 kubectl get -n gatling-k8s-k8s --show-kind --ignore-not-found
kubectl logs `kubectl get pod -o name -n gatling-k8s-k8s` -n gatling-k8s-k8s
```

Check on [Gatling IO](https://cloud.gatling.io/o/adobe-identity-poc/private-locations/control-planes)


* Upgrade

```bash
helm upgrade  k8s-k8s .   -n gatling-k8s-k8s
```

* Debug

```bash
helm upgrade  k8s-k8s . --dry-run --debug  -n gatling-k8s-k8s
```


* Uninstall

```bash
helm uninstall k8s-k8s -n gatling-k8s-k8s
```

Harsher method:
```bash
kubectl delete namespace gatling-k8s-k8s
```
