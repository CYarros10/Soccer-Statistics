import sys
import json

def hw():
    print 'Hello, world!'

def lines(fp):
    print str(len(fp.readlines()))

def main():
    sent_file = open(sys.argv[1])
    tweet_file = open(sys.argv[2])
    hw()
    lines(sent_file)
    lines(tweet_file)

if __name__ == '__main__':
    main()
    
# Dictionary of word scores
afinnfile = open("AFINN-111.txt")
scores = {} # initialize an empty dictionary
for line in afinnfile:
  term, score  = line.split("\t")  # The file is tab-delimited. "\t" means "tab character"
  scores[term] = int(score)  # Convert the score to an integer.

print scores.items

# Open file, load each tweet into a dictionary (words), and return a sentiment score for each tweet
outputfile = open("output2.txt")


sentiment_score = 0
for line in outputfile:
    response = json.loads(line)
    
    # in the json object, identify text value and create a string that will resemble each tweet
    if u'text' in response: 
        unicode_string = response[u'text']
        encoded_string = unicode_string.encode('utf-8')
        print "New Tweet ---> " + encoded_string
        
        #List of tweet words
        tweetWords = encoded_string.split()
        # for each word in the list
        for value in tweetWords:
            
            # if the word is a key in scores dictionary
            if value in scores:
            
                # get the value of that key and add it to total score
                sentiment_score += scores.get(value)
    
        print ""
        print "Score: " + str(sentiment_score)
        print ""        

    
    
    