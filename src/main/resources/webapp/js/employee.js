$(document).ready(function () {
    $("#search").click(searchClickHandler);

    function getAllEmployees() {
        $.get(window.env.apiUrl)
            .done(getRawEmployeesTBody)
            .fail(getRawTbodyWithoutResults);
    }

    function findEmployeeById(id) {
        $.get(`${window.env.apiUrl}/${id}`)
            .done(getRawEmployeeTBody)
            .fail(getRawTbodyWithoutResults);
    }

    function getRawEmployeesTBody(data) {
        let raw = '';

        for (let i = 0; i < data.length; i++) {
            let dataItem = {
                id: data[i].id,
                name: data[i].name,
                contract: {
                    contractType: data[i].contract.contractType,
                    hourlySalary: data[i].contract.hourlySalary,
                    monthlySalary: data[i].contract.monthlySalary,
                    annualSalary: data[i].contract.annualSalary
                },
                rol: {
                    roleName: data[i].rol.roleName
                }
            }
            raw += getRawTbody(dataItem);
        }

        clearTable();
        rawTBody(raw);
    }

    function getRawEmployeeTBody(data) {
        clearTable();
        rawTBody(getRawTbody(data));
    }

    function getRawTbody(data) {
        var raw = `
        <tr>
            <th scope="row">${data.id}</th>
            <td>${data.name}</td>
            <td>${data.contract.contractType}</td>
            <td>${data.contract.hourlySalary}</td>
            <td>${data.contract.monthlySalary}</td>
            <td>${data.contract.annualSalary}</td>
            <td>${data.rol.roleName}</td>
        </tr>
    `;

        return raw
    }

    function getRawTbodyWithoutResults(data) {
        var raw = `
        <tr>
            <th scope="row">without results</th>
        </tr>
    `;
        return raw
    }

    function clearTable() {
        $('#employeesTable > tbody > tr').remove();
    }

    function rawTBody(raw) {
        $('#employeesTable > tbody').append(raw);
    }

    function searchClickHandler() {
        let id = $("#id").val();

        if (id !== '') {
            findEmployeeById(id);
        } else {
            getAllEmployees();
        }
    }
});