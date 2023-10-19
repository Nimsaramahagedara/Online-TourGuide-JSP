
function showLogOut(){
    var menu = document.getElementsByClassName('logout')[0];
    var icon = document.getElementById('logout-btn');
    if( icon.className == 'fa-solid fa-chevron-down' ){
        menu.style.display = 'block';
        icon.className = 'fa-solid fa-chevron-up';
    }else{
        menu.style.display = 'none';
        icon.className = 'fa-solid fa-chevron-down';
    }
}

function showNavi(){
    var navi = document.getElementsByClassName('navigation')[0];
    var dash = document.getElementsByClassName('dashboard')[0];
    if( navi.style.margin == '0px'){
        navi.style.margin = '0 0 0 -25%';
        dash.style.flexBasis = '100%';

    }else{
        navi.style.margin = '0 0 0 0px';
    }

}


