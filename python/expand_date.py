import sys
from datetime import datetime
# 02/06/92 -> 2nd June 1992 or 06th February 1992


def date_formatted_using_datetime_class(input: str):
	possible_formats = ['%d/%m/%y', '%m/%d/%y']
	for format in possible_formats:
		try:
			parsed_date = datetime.strptime(input, format)
			print(parsed_date.strftime('%d %b, %Y'))
		except:
			pass


input = sys.argv[1] if len(sys.argv) > 1 else '02/06/92'
date_formatted_using_datetime_class(input)
