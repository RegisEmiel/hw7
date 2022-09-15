angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/hw7/api/v1';

    $scope.fillTable = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.StudentsList = response.data;
            });
    };

    $scope.fillTable();

    $scope.deleteStudentById = function (id) {
        $http.delete(contextPath + '/students/' + id)
            .then(function (response) {
                $scope.fillTable()
            });
    };

    $scope.createStudent = function () {
        $http.post(contextPath + '/students', $scope.newStudent)
            .then(function (response) {
                $scope.newStudent = null;
                $scope.fillTable();
            });
    };

    $scope.editStudent = function (student) {
        $scope.newStudent = new Object();
        $scope.newStudent.id = student.id;
        $scope.newStudent.name = student.name;
        $scope.newStudent.age = student.age;
    }

    $scope.updateStudent = function () {
        $http.put(contextPath + '/students', $scope.newStudent)
            .then(function (response) {
                $scope.newStudent = null;
                $scope.fillTable();
            });
    };


    $scope.saveOrUpdate = function () {
        if ($scope.newStudent.id == null) {
            $http.post(contextPath + '/students', $scope.newStudent)
                .then(function (response) {
                    $scope.newStudent = null;
                    $scope.fillTable();
                });
        }
        else {
            $http.put(contextPath + '/students', $scope.newStudent)
                .then(function (response) {
                    $scope.newStudent = null;
                    $scope.fillTable();
                });
            }
    };
});