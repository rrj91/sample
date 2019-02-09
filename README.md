# sample #
just fo fun
Sample request from postman <br/>
## Create two sample company ##
```json 
{
"name":"IBM",
"description":"Good Company"
}
```
## Create sample role ##

```json
{
"name":"Developer",
"description":"AEM"
}
```
## Create sample use user ##
```json
{
"name":"Test User",
"description":"Developer"
}
```
## For a deal use this json ##
POST http://localhost:8080/companies/<source_comapny_id>/deals
```json
{
"name":"TCS Deal",
"description":"Good Deal",
"targetCompany": {
	"id":<generated company id>
},
"role":{
		"id": <generated id of role>
	},
"user":{
		"id":<generated id of user>
	}
}
```
## You can add more role and user on same deal by providing id to it ##
```json
{
"id": <deal id>
"role":{
		"id": <generated id of role>
	},
"user":{
		"id":<generated id of user>
	}
}
```
