{{- define "configFileContent" -}}
control-plane
{{-  toPrettyJson .Values.controlPlane }}
{{- end }}
