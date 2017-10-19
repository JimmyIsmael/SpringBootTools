/**
 * Created by Jimmy Pena on 8/24/2017.
 */
function searchSalesman() {
    var zrt=document.getElementById('ZRT').value;
    var name=document.getElementById('salesmanName').value;

    if (zrt!=""){
        window.location.href="/searchByZRT/"+zrt;
    }
    else {
        if (name!="") {
            window.location.href="/searchByName/"+name;
        }
        else{
            window.location.href="/";
        }
    }

}
function exportToCSV() {
    window.location.href="/exportToCSV";
}
