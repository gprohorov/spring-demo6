<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="width: 200px">
    <fieldset>
        <legend> Add item</legend>
        <form name="item" action="" method="POST">
            Name : <@spring.formInput "form.name" "" "text"/>
            <br>
            Description: <@spring.formInput "form.description" "" "text"/>
            <br>

            Created: <@spring.formInput "form.createdAt" "" "date"/>
            <br>
            <input type=submit value="Update">
        </form>

    </fieldset>
</div>



</body>
</html>
