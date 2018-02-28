<?php
if(!isset($_POST['submit']))
{
	//This page should not be accessed directly. Need to submit the form.
	echo "error; Sie müssen das Formular ausfüllen und auf senden klicken.";
}
$name = $_POST['name'];
$visitor_email = $_POST['email'];
$message = $_POST['message'];

//Validate first
if(empty($name)||empty($visitor_email)) 
{
    echo "Name und Email müssen ausgefüllt werden!";
    exit;
}

if(IsInjected($visitor_email))
{
    echo "Email-Format nicht zulaessig!";
    exit;
}

$email_from = 'jasmin.moos@gmail.com';
$email_subject = "New Form submission - Contact";
$email_body = "Sie haben eine Nachricht von dem Benutzer $name. erhalten.\n".
    "Die Nachricht lautet:\n $message".
    
$to = "jasmin.moos@gmail.com";
$headers = "Von: $email_from \r\n";
$headers .= "Antwort an: $visitor_email \r\n";
//Email senden
mail($to,$email_subject,$email_body,$headers);
?>
Vielen Dank f�r deine Nachricht!
<?php >
// Validierung um Spamming vorzubeugen
function IsInjected($str)
{
  $injections = array('(\n+)',
              '(\r+)',
              '(\t+)',
              '(%0A+)',
              '(%0D+)',
              '(%08+)',
              '(%09+)'
              );
  $inject = join('|', $injections);
  $inject = "/$inject/i";
  if(preg_match($inject,$str))
    {
    return true;
  }
  else
    {
    return false;
  }
}
   
?> 