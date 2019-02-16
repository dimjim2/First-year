#this program factors an integer
n=int(input('Enter an  integer: '))
#in order to calculate the factorization of an integer because it is either positive or negative so  we take the absolute of n
n1=abs(n)
#either of two are prime so we cannot factorize them
if (n1==0 or n1==1):
	print ("we cannot find the prime factors of the number ")
else:
	i=1
	my_list=[]
	while(i<=n1):
		k=0
		if (n1%i==0):
			j=1
			while (j<=i):
				if (i%j==0):
					k=k+1
				j=j+1
			if (k==2):
				#so i is prime and we append it in the list
				my_list.append(i)
		i=i+1
	list=[]
	for number in my_list:
		count=0
		F=False
		while (F==False):
			if (n1%number==0):
				count=count+1
				n1=n1//number
			else:
					list.append(str(number)+'**'+str(count))
					F=True
	print("The factorization is:")
	if n>0:
		for el in list:
			#print the prime factor
			print ("("+el+")",end=" ")
	elif n<0:
		c=False
		for el in list:
			if c==False:
				#for the first prime factor we type also type the negative sign
				print ("(-1)("+el+")",end=" ")
				c=True
			else:
				#print the prime factor
				print ("("+el+")",end=" ")
			
		