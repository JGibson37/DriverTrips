# DriverTrips

I began the project by writing down what I knew I needed to know from the prompt. This included some psuedo coding object structure. I also wrote the "rules" that 
the program needed to abide by, and gathered the formula for determining speed. Once I began coding I wrote simple tests to create my objects, and in the beginning
most of my logic methods were held inside the Trip object. I soon realized that I needed to separate the Trip object from the logic methods and created the TripManager 
object to house my logic methods. When I was confident I had enough methods to give me the functionality I needed, I moved on the developing the DriverTripApp class.
I started with implementing the file input function and created an input file for it to read with the test data from the provided prompt. After I ensured it was 
working correctly I moved on to creating a String parser so that I could break down the incoming commands. Once successful, I began implementing logic for the commands.
Throughout the process I would realize I did not have a certain functionality required from my objects, so I would stop working on the app, implement testing and code
for my desired functionality, and then return to the App to continue working on it. This became a cycle until I finally had all the functionality needed to complete
the App according to the prompt. Once I believed I was finished, I re-read my prompt and evaluated my code to ensure it suited all the requests. Finally as a last step,
I implemented some refactoring to enhance my code readability.
