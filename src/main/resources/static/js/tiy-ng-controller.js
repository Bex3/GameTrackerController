angular.module('TIYAngularApp', [])
   .controller('SampleController', function($scope, $http) {
        $scope.name = "James";
        $scope.whateverIWantToComeUpWith = "this is what I wanted to come up with";
        $scope.testVar = {};
        $scope.testVar.sampleContainerVar = "something else";
        $scope.testVar.anotherSample = 12;
        $scope.testVar.flagExample = false;


        $scope.newGame = {};
    });
