angular.module('TIYAngularApp', [])
   .controller('SampleController', function($scope, $http) {
        $scope.name = "James";
        $scope.whateverIWantToComeUpWith = "this is what I wanted to come up with";
        $scope.testVar = {};
        $scope.testVar.sampleContainerVar = "something else";
        $scope.testVar.anotherSample = 12;
        $scope.testVar.flagExample = false;

        $scope.getGames = function() {
            console.log("About to go get me some data!");
            $scope.name = "JavaScript Master Guru";

            $http.get("//localhost:8080/games.json") //asynch call
                .then( //provides the callback
                    function successCallback(response) { //inside of the promise object then holds the 2 functions
                        console.log(response.data); //data is the json object as a javascript object
                        console.log("Adding data to scope");
                        $scope.games = response.data;
                    },
                    function errorCallback(response) {
                        console.log("Unable to get data");
                    });
                    console.log("Done with the promise - waiting for the callback");
        };

        $scope.toggleGame = function(gameID) {
            console.log("About to toggle game with ID " + gameID);

            $http.get("/toggleGame.json?gameID=" + gameID)
                .then(
                    function success(response) {
                        console.log(response.data);
                        console.log("Game toggled");

                        $scope.games = {};
                        alert("About to refresh the games on the scope"); //pauses the execution of the js code

                        $scope.games = response.data;
                    },
                    function error(response) {
                        console.log("Unable to toggle game");
                    });
        };

        $scope.addGame = function() {
            console.log("About to add the following game " + JSON.stringify($scope.newGame));

            $http.post("/addGame.json", $scope.newGame)
                .then(
                    function successCallback(response) {
                        console.log(response.data);
                        console.log("Adding data to scope");
                        $scope.games = response.data;
                    },
                    function errorCallback(response) {
                        console.log("Unable to get data");
                    });
        };

        $scope.newGame = {}; //if we want to use use scope on the new game in the view we must make it exist first
    });
