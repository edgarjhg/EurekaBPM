/**
 * 
 */
'use strict';
 
App.controller('PeopleController', ['$scope', 'PeopleService', function($scope, PeopleService) {
          var self = this;
          self.people={soeid:'',nombre:'',apellidoPaterno:''};
          self.users=[];
               
          self.fetchAllUsers = function(){
        	  PeopleService.fetchAllUsers()
                  .then(
                               function(d) {
                                    self.users = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.createUser = function(people){
        	  PeopleService.createPeople(people)
                      .then(
                      self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Error while creating User.');
                              } 
                  );
          };
 
         self.updateUser = function(user, id){
        	 PeopleService.updateUser(user, id)
                      .then(
                              self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Error while updating User.');
                              } 
                  );
          };
 
         self.deleteUser = function(id){
        	 PeopleService.deleteUser(id)
                      .then(
                              self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Error while deleting User.');
                              } 
                  );
          };
 
          self.fetchAllUsers();
 
          self.submit = function() {
              if(self.people.soeid===null){
                  console.log('Saving New User', self.people);    
                  self.createUser(self.people);
              }else{
                  //self.updateUser(self.people, self.people.soeid);
                  console.log('User updated with id ', self.people.soeid);
                  self.createUser(self.people);
              }
              self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.users.length; i++){
                  if(self.users[i].soeid === soeid) {
                     self.people = angular.copy(self.users[i]);
                     break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.user.soeid === soeid) {//clean form if the user to be deleted is shown there.
                 self.reset();
              }
              self.deleteUser(id);
          };
 
           
          self.reset = function(){
              self.user={id:null,username:'',address:'',email:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);