

function check(){
	const e = document.getElementById('email').value;
	const p = document.getElementById('password').value;
	const a = document.getElementById('error');
	const b =document.getElementById('submit');
	
	
	if(p == "" || e == "" ){
		b.disabled = true;
		var text = "Fields are Empty";
		a.innerHTML = text;
	
	}else{

		b.disabled = false;
		a.innerHTML = null;
	}
}
