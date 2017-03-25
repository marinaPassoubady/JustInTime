function hideThis(_div)
{
var obj = document.getElementById('select');
if (select.options[select.selectedIndex].value == 1) {
	
	 form1.style.display = 'none';
	 }
    if (select.options[select.selectedIndex].value == 2) {
 form1.style.display = 'block';
 } else {
 form1.style.display = 'none';
 }
 if (select.options[select.selectedIndex].value == 3) {
 form2.style.display = 'block';
 } else {
 form2.style.display = 'none';
 }
 if (select.options[select.selectedIndex].value == 4) {
 form3.style.display = 'block';
 } else {
 form3.style.display = 'none';
 }
}

function verifPseudo(champ)
{
   if(champ.value.length < 2 || champ.value.length > 25)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifAdresse(champ)
{
   if(champ.value.length < 15 || champ.value.length > 55)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifAge(champ)
{
   var age = parseInt(champ.value);
   if(isNaN(age) || age < 5 || age > 111)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifMail(champ)
{
   var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
   if(!regex.test(champ.value))
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}