"""
    Created on : Nov 19, 2024
    Author : Christopher Gedler <cgedler@gmail.com>
    version : 1.0
"""

import io
import json
import os.path
import glob
import datetime as day
from datetime import datetime
newDate = str(day.date.today())
newDateTime = str(datetime.now())

def readFileJSON(namefile):
    #dir = 'topics'
    #finalName = '/%s.json' % namefile
    #fullPath = dir + finalName
    #fullPath = finalName
    fullPath = namefile
    try:
        with open(fullPath) as jsonFile:
            data = json.load(jsonFile)
            return data
    except Exception as e:
        print('The File ', fullPath, ' not read Exception : {}'.format(e))


if __name__ == "__main__":
    #print(os.path.abspath(os.getcwd()))
    dir = os.path.abspath(os.getcwd())
    txtfiles = []
    for file in glob.glob("topics/*.json"):
        txtfiles.append(file)
    
    finalName = dir + '/%s_RESULT.log' % newDate
    if not os.path.isfile(finalName):
        try:
            f = open(finalName, 'wb')
            #f = open(finalName, 'a+', encoding='utf-8')
            f.write('--EVENT : ' + '\n')
            f.close()
        except FileExistsError:
            print('The File already exists')
    
    else:
        f = open(finalName , 'a+', encoding='utf-8')
        for file in txtfiles: 
            data = readFileJSON(file)
            for p in data:
                f.write('{'+ '\n')
                f.write('\t\"title\": \"' + p + '\",'+ '\n')
                f.write('\t\"file\": \"--\" '+ '\n')
                f.write('},'+ '\n')
        f.close()

   
    
    