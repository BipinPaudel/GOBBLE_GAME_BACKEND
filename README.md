# GOBBLE WORD SEARCH API

- The following project is implemented using Java EE/ CDI framework using jdk 11.

## Getting Started ##
- Clone the project in your system
- Make sure you have docker installed to start the application
- After cloning, open a terminal, go to the root folder of the project and perform the 
   following commands.
   
   1. docker image build -t gobble_image
   2. docker run -p 8080:8080 gobble_image
   
   The first command will build a docker image that consists of jar file of the project. The
   second command will run the image and it can be accessed locally in port 8080. localhost:8080
   
# APIs #

There are altogether two apis in the system.

## FETCH GRID ##
    - This API will provided 4*4 random character grid.
    
### Resource URL ###
```
HOST_URL/v1/gobble/grid
```
### Method ####

```HTTP GET```

#### Response ####

```json
{
    "code": "0",
    "message": "SUCCESS",
    "data": [
        [ "e", "e","t", "b" ],
        [  "y", "y","n","l"],
        [ "a", "f", "z","y"],
        [ "i", "f", "x", "c" ]
    ]
}
```

#### Response parameters

| Name  |Description |Possible values |
| ------------- | ------------- | -----------|
| code  | 0 if success response  |  |
| message  | SUCCESS |  |
| data  | 4*4 grid of characters|  |




## GOBBLE GAME API ##
    - This API consumes user input words and grid and provides the final response
    by searching the words in grid and and calculates the total score.
    
### Resource URL ###
```
HOST_URL/v1/gobble
```
### Method ####

```HTTP POST```

#### Request

```json
{
"inputWords":["oath", "pea", "eat","hira", "rain", "oat", "kira", "nakin", "haki","hakil"],
"grid":[["o", "a", "a", "n"],["e", "t", "a", "e"],["l", "h", "k", "r"],["i", "n", "i", "a"]]
}
```

| Name  |Description |Validation | 
| ----------------- | ------------- | -----------| 
| inputWords  | List of words give by the user  | Required | 
| grid  | 4*4 character grid | Required  |

#### Response

```json
{
    "code": "0",
    "message": "SUCCESS",
    "data": {
        "grid": [
            [  "o", "a","a", "n"  ],
            [ "e", "t",  "a", "e" ],
            [ "l", "h",  "k", "r" ],
            [  "i",  "n","i", "a" ]
        ],
        "wordMap": {
            "hira": false,
            "rain": true,
            "hakil": false,
            "oat": true,
            "oath": true,
            "nakin": false,
            "haki": false,
            "eat": true,
            "pea": false,
            "kira": false
        },
        "totalScore": 14
    }
}
```
    
| Name  |Description |Possible values |
| ------------- | ------------- | -----------|
| code  | 0 if success response  |  |
| message  | SUCCESS |  |
| data  | Game Result |  |

#### Game Result element

| Name  |Description |Possible values |
| ------------- | ------------- | -----------|
| grid  | 4*4 character grid of the current game  |  |
| wordMap  | map of the word denoting whether the input words are valid or not. If valid, the word will count for the total score  |  |
| totalScore  | Sum of all the total valid word length  |  |

#### Error codes

| code  |message |
| ------------- | ------------- |
| GE01  | Input word list is empty  |
| GE02  | Invalid grid characters  |
| GE03  | Input words are repeated  |
| GE04  | Input word contains other than alphabetic characters  |
| GE05  |Input word is less than 3 characters |
| GE06  |Grid is empty  |


## Code Description

- Input Data is validated in the beginning. 
- Input Words are validated against the dictionary words.
    1. There is a word file that contains almost 370000 valid English words.
    2. The file is read only once and stored in HashSet that has search time complexity of 
    O(n).
    3. The dictionary set then, resides in memory until the server is stopped.
- Valid words are filtered from dictionary then.
- TrieData structure is used to convert all the valid input words to the tree format.
- Depth first search algorithm is used in the grid to search whether the word.
- Finally total score is counted on the basis of sum of length of all the valid input words that
are found in grid.

- 100% test coverage is maintained for all the code that consists of business logic. 