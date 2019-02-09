# sample
just fo fun
Sample request from postman
```json
{
	"info": {
		"_postman_id": "04f4a1e2-9183-4bb2-86cc-b89d7dea75ec",
		"name": "List Of Request",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "http://localhost:8080/companies",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\"name\":\"TCS\",\n\"description\":\"Poor Company\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/companies",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"companies"
					]
				},
				"description": "adding companies"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/companies",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\"name\":\"IBM\",\n\"description\":\"Good Company\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/companies",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"companies"
					]
				},
				"description": "adding company"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/companies/1/deals",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\"name\":\"TCS Deal\",\n\"description\":\"Good Deal\",\n\"targetCompany\": {\n\t\"id\":2\n}\n}"
				},
				"url": {
					"raw": "http://localhost:8080/companies/1/deals",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"companies",
						"1",
						"deals"
					]
				},
				"description": "adding a deal"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/deals",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\"name\":\"TCS Deal\",\n\"description\":\"Good Deal\",\n\"targetCompany\": {\n\t\"id\":2\n}\n}"
				},
				"url": {
					"raw": "http://localhost:8080/deals",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"deals"
					]
				},
				"description": "quering deals"
			},
			"response": []
		}
	]
}
```
