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
                        console.log(response.data); //data is the json object as a javascropt object
                        console.log("Adding data to scope");
                        $scope.games = response.data;
                    },
                    function errorCallback(response) {
                        console.log("Unable to get data");
                    });
                    console.log("Done with the promise - waiting for the callback");
        };

        $scope.newGame = {};
    });
