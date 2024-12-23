* Pre-requesites

  Run only once:

```bash
helm dependency build
```
* Installation

```bash
kubectl delete namespace gatling-k8s-aws
kubectl create namespace gatling-k8s-aws
./set_secrets.sh
helm install k8s-aws . -n gatling-k8s-aws
```

* Status

``` bash
helm list 
kubectl -n gatling-k8s-aws api-resources --verbs=list --namespaced -o name  | xargs -n 1 kubectl get -n gatling-k8s-aws --show-kind --ignore-not-found
kubectl logs `kubectl get pod -o name -n gatling-k8s-aws` -n gatling-k8s-aws
```

Check on [Gatling IO](https://cloud.gatling.io/o/adobe-identity-poc/private-locations/control-planes)


* Upgrade

```bash
helm upgrade  k8s-aws .   
```

* Debug

```bash
helm upgrade  k8s-aws . --dry-run --debug  -n gatling-k8s-aws
```


* Uninstall

```bash
helm uninstall k8s-aws -n gatling-k8s-aws
```

Harsher method:
```bash
kubectl delete namespace gatling-k8s-aws
```
