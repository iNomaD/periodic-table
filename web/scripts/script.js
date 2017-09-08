/**
 * Created by Denis on 08.09.2017.
 */
function show(state){

    document.getElementById('window').style.display = state;
    document.getElementById('wrap').style.display = state;
}

function changeInfo(title, description){
    document.getElementById("elementTitle").innerHTML = title;
    document.getElementById("elementDescription").innerHTML = description;
}

function loadElement(elementName){
    changeInfo("loading...", "loading...");
    show('block');
    var q_str = 'elementName='+elementName;
    doAjax('PeriodicTableServlet',q_str,'doQuery_back','post',0);
}

function doQuery_back(result)
{
    result = JSON.parse(result);
    var atomicNumber = result.atomicNumber;
    var symbol = result.symbol;
    var definition = result.definition;
    changeInfo(symbol+" ["+atomicNumber+"]", definition);
}