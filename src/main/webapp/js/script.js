function menu(){
    const menu = document.getElementsByClassName('drop-menu')[0];
    const btn = document.getElementById("menubtn");
    if(menu.style.display == 'block'){
        btn.className = "fa-solid fa-chevron-down";
        menu.style.display = 'none';
    }else{
        menu.style.display = 'block';
        btn.className = "fa-sharp fa-solid fa-chevron-up";
    }
}

function addInputSubmitEvent(form, input) {
    input.onkeydown = function(e) {
        e = e || window.event;
        if (e.keyCode == 13) {
            form.submit();
            return false;
        }
    };
}
