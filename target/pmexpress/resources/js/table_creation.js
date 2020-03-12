function addTable() {
    let e = document.getElementById("loc");
    let strUser = e.options[e.selectedIndex].value;
    let body = document.querySelector("body");
    let rows = strUser;
    let columns = 2;
    let tr = "";
    let td = "";
    let firstTable = document.querySelector("table");
    let table = document.getElementById("table");
    let tableSum = document.getElementById("tableSum");
    document.getElementById("table").addEventListener("keydown", (evt) => {
        if (evt.keyCode === 13) {
            evt.preventDefault();
        }
    });
    document.getElementById("tableSum").addEventListener("keydown", (evt) => {
        if (evt.keyCode === 13) {
            evt.preventDefault();
        }
    });
    table.setAttribute("border", "2px");
    tableSum.setAttribute("border", "2px");
    if (table.style.display === "none") {
        table.style.display = "inline-table";
        tableSum.style.display = "inline-table";
    } else {
        table.style.display = "none";
        tableSum.style.display= "none";
    }

    tr = document.createElement("tr");
    td = document.createElement("td");
    td.setAttribute("contenteditable","true");
    tr.appendChild(td);
    tableSum.appendChild(tr);

    tr="";
    td="";

    let k=0;
    for (let i = 0; i < rows; i++) {
        tr = document.createElement("tr");
        for (let j = 0; j < columns; j++) {
            td = document.createElement("td");
            td.setAttribute("contenteditable","true");
            tr.appendChild(td);
            if (j===columns-1) {
                k++;
                td = document.createElement("td");
                    let checkbox = document.createElement('input');
                    checkbox.type = "checkbox";
                    checkbox.name = "name";
                    checkbox.value = "true";
                    checkbox.id="checkbox"+k;
                    td.appendChild(checkbox);
                tr.appendChild(td);
                k++;
                td = document.createElement("td");
                checkbox = document.createElement('input');
                checkbox.type = "checkbox";
                checkbox.name = "name";
                checkbox.value = "true";
                checkbox.id="checkbox"+k;
                td.appendChild(checkbox);
                tr.appendChild(td);
            }
        }
        table.appendChild(tr);
    }


    if (firstTable == null) {
        return body.appendChild(table);
    } else {
        let newTable = body.appendChild(table);
        return document.body.replaceChild(newTable, firstTable);
    }
}

function saveToDb() {

    function Event(nameEvent, kefEvent, loseEvent, backEvent, sumEvent) {
    }

    function Events(events) {
        this.events = Array.from(events);
    }

    Events.prototype.addEvent = function (event) {
        this.events = this.events.concat(event);
    }

    let event;
    let myEvents;

    let k=1;
    for (var i = 1, row; row = table.rows[i]; i++) {
        for (var j = 0, col; col = row.cells[j]; j++) {
            if (j===0){
                event = new Event();
                event.nameEvent = col.innerText;
                event.sumEvent = tableSum.rows[1].cells[0].innerText;
            }
            if (j===1){
                event.kefEvent = col.innerText;
            }
            if (j===2){
                let checkbox = document.getElementById("checkbox"+k);
                k++;
                if (checkbox.checked === true){
                event.backEvent = "true";
                } else { event.backEvent = "false";}
            }
            if (j===3){
                let checkbox = document.getElementById("checkbox"+k);
                k++;
                if (checkbox.checked === true){
                    event.loseEvent = "true";
                } else { event.loseEvent = "false";}
            }
            if ( i===1 && j===0 ){
                myEvents = new Events([]);
              }

            if (j+1 === row.cells.length){
                myEvents.addEvent(event);
            }
        }
    }

    const jsonData = JSON.stringify(myEvents);
    console.log("jsonData");
    console.log(jsonData);

    $.ajax({
        type: "POST",
        traditional:true,
        url: "add",
        contentType : 'application/json; charset=utf-8',
        dataType: 'json',
        data: jsonData,
        complete: function () {
            window.location.replace("sum");
        }
    });

}
