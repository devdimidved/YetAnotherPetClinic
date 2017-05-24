<#include "header.ftl">
<ul class="nav nav-pills nav-justified">
    <li role="presentation"><a href="/owners">OWNERS</a></li>
    <li role="presentation"><a href="/vets">VETERINARIANS</a></li>
    <li role="presentation"><a href="/pettypes">PET TYPES</a></li>
</ul>
<hr>
<div class="container">
    <h3>Owner information</h3>
    <table class="table table-condensed table-striped">
        <tr>
            <th>Name</th>
            <td><b>${owner.firstName} ${owner.lastName}</b></td>
        </tr>
        <tr>
            <th>City</th>
            <td>${owner.city}</td>
        </tr>
        <tr>
            <th>Address</th>
            <td>${owner.address}</td>
        </tr>
        <tr>
            <th>Phone</th>
            <td>${owner.phone}</td>
        </tr>
    </table>
    <a href="/owners/edit/${owner.id}" class="btn btn-primary btn-sm">Edit owner</a>
    <a href="/owners/${owner.id}/pets/add" class="btn btn-success btn-sm">Add new pet</a>
    <br>
    <br>
    <h4>Pets and Visits</h4>
    <table class="table table-condensed table-bordered">
    <#list owner.pets?sort_by("birthDate") as pet>
        <tr>
            <td class="col-sm-3">
                    <table class="table table-condensed">
                        <tr>
                            <th class="col-sm-1">Name</th>
                            <td class="col-sm-2">${pet.name}</td>
                        </tr>
                        <tr>
                            <th>Birth date</th>
                            <td>${pet.birthDate}</td>
                        </tr>
                        <tr>
                            <th>Type</th>
                            <td>${pet.petType.name}</td>
                        </tr>
                    </table>
                    <a href="/owners/${owner.id}/pets/edit/${pet.id}" class="btn btn-primary btn-xs">Edit pet</a>
                    <a href="/owners/${owner.id}/pets/delete/${pet.id}" class="btn btn-danger btn-xs">Delete pet</a> &nbsp; &nbsp;
                    <a href="/owners/${owner.id}/pets/${pet.id}/visits/add" class="btn btn-success btn-xs">Add new visit</a>
                </dl>
            </td>
            <td class="col-sm-9">
                <table class="table table-condensed table-striped">
                    <tr>
                        <th class="col-sm-2">Visit date</th>
                        <th class="col-sm-7">Description</th>
                    </tr>
                <#list pet.visits as visit>
                    <tr>
                        <td><a href="/owners/${owner.id}/pets/${pet.id}/visits/edit/${visit.id}" class="btn btn-primary btn-xs">Edit</a> &nbsp; ${visit.visitDate}</td>
                        <td>${visit.description}</td>
                    </tr>
                </#list>
                </table>
            </td>
        </tr>
    </#list>
    </table>
</div>
<#include "footer.ftl">
