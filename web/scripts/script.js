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

function loadElement(name){
    changeInfo("loading...", "loading...");
    show('block');

}