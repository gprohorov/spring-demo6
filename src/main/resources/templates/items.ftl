<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1> Items  table</h1>

<table class="table table-dark table-striped" >
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>DAY</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Delete</th>
        <th>Edit</th>


    </tr>
    <#list items as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.description}</td>
            <td>${item.day}</td>
            <td>${item.createdAt}</td>
            <td ><#if item.updatedAt??>
                ${item.updatedAt}
                <#else> No update
                </#if>
            </td>

            <td> <a href="/ui/v1/items/delete/${item.id}"  >Delete</a></td>
            <td> <a href="/ui/v1/items/edit/${item.id}">Edit</a></td>
        </tr>
    </#list>
</table>

<a  href="/ui/v1/items"> Create </a>

</body>
</html>
