x = 'marty';


def permute(string, subs):
	print ("permute { subs: " + subs + ", string: " + string + "}")
	if string == "":
		print (subs)
	else:
		for i in range(0, len(string)):
			c = string[i]
			subs += c
			string = string[:i] + string[i + 1:]
			permute(string, subs)
			subs = subs[:-1]
			string = c + string

permute(x, "")