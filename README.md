
```sbtshell
curl -XPOST "http://localhost:10001/fescar_demo/v1/purchase" -H "Content-Type:application/json" -d '{
	"name": "lisi",
	"code": "s0001",
	"quality": 4,
	"unitPrice": 50
}'
```