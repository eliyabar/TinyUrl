## Siemens Home Assignment
This is my interpretation of the Tiny URL app

## Note
#### Changes that I added to the original requirements: <br>
1. "Same URL will always generate the same tiny URL."
2. "Next to the input field place a 'Save' button which will initiate the creation of a tiny URL."
3. "Input field for placing a tiny URL and a button 'Show Full URL' to retrieve the full URL bound to a tiny URL."
4. "Single Page App approach"
#####Why?
1. Each Original url is bound to a tiny url, it will generate a new one. This is due to the face that every url have an expiration date and 2 urls can have 2 tiny urls with different expiration date.
2. Took the liberty to change a bit the UI, there is no Save button, only a button with a conversion icon that makes the same operation.
3. Another UI change, just divided it to separate tabs.
4. For Utilization of Single Page approach we should have multiple pages, then we would use React Router to statically or dynamically change the routes while staying in the same page. For this assignment I didn't see a reason to implement routing but added tabs that generates different React components over the same div without redirecting to some other url. 

#### What would I add given more time?:
- Clear off the dust, learn new best practices and additions to JAVA and Spring (last time I used this stack was about 2 years ago)
- More validation over the url field - as for now it is using the default URL validation of Hibernate validation.
- Debouncing creation of request for each user - it could be easily overflow the server's memory or even DB if it was connected.
- Better Cross configurations (client and server) - right now everything is pretty hard-codded 
- Using yaml file instead of application.props
- Making the App run both front and back from a single location, I've managed to bundle them together in the same jar, but I wanted to configure it to work properly (apps should run independently).
- Handling Errors - could not make the error message to appear on the request for some reason.
- Adding worker that will clear each day the expired urls from memory.
- Adding more tests, maybe even ui tests

## Code style
In the client, I'm using Typescript to maintain a uniform coding style and using the React Hooks feature.

## Tech/framework used fo client
<b>Built with</b>
- [React](https://reactjs.org/) as client framework
- [Ant Design](https://ant.design/) for UI components  

## Tech/framework used fo backend
<b>Built with</b>
- Spring boot
- H2 in memory DB (data is volatile)
- Hibernate as an ORM
- Maven as software project management

## Installation
 
To run the server, make sure you can run [Sping boot app](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-installing-spring-boot)
I'm using Intellij as my runner for the backend
install dependencies and run the spring boot app.


To run the client, you need first to go into the client (root/client) folder of this repo and install its dependencies.  
use:  
``yarn install``  
Important note - you must [install yarn](https://classic.yarnpkg.com/en/docs/install), this will not work with other package managers like npm.
Use the following command to run the React client.
``yarn start``

If you are using npm as your package manager use:
``npm install``  
``npm start``


## License
MIT © [Eliya Bar On]()
