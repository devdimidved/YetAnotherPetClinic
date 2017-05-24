<#include "header.ftl">
    <ul class="nav nav-pills nav-justified">
        <li role="presentation"><a href="/owners">OWNERS</a></li>
        <li role="presentation"><a href="/vets">VETERINARIANS</a></li>
        <li role="presentation"><a href="/pettypes">PET TYPES</a></li>
    </ul>
<hr>
<div class="container">
    <div class="jumbotron alert-danger">
        <h1>Oops!</h1>
        <h2>Something went wrong!</h2>
        <h3>${status} ${error}</h3>
    </div>
</div>
<#include "footer.ftl">
