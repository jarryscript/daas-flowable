/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
'use strict';



angular.module('flowableModeler')
.controller('EventFlowsCtrl', ['$rootScope', '$scope', '$translate', '$http', '$timeout','$location', '$modal', function ($rootScope, $scope, $translate, $http, $timeout, $location, $modal) {

    // Main page (needed for visual indicator of current page)
    $rootScope.setMainPageById('event-flows');
    $rootScope.formItems = undefined;

    // get latest thumbnails
    $scope.imageVersion = Date.now();

	  $scope.model = {
      filters: [
          {id: 'event-flows', labelKey: 'EVENTFLOWS'}
		],

		sorts: [
		        {id: 'modifiedDesc', labelKey: 'MODIFIED-DESC'},
		        {id: 'modifiedAsc', labelKey: 'MODIFIED-ASC'},
		        {id: 'nameAsc', labelKey: 'NAME-ASC'},
		        {id: 'nameDesc', labelKey: 'NAME-DESC'}
		]
	  };

	  if ($rootScope.modelFilter) {
		  $scope.model.activeFilter = $rootScope.modelFilter.filter;
		  $scope.model.activeSort = $rootScope.modelFilter.sort;
		  $scope.model.filterText = $rootScope.modelFilter.filterText;

	  } else {
		  // By default, show first filter and use first sort
	      $scope.model.activeFilter = $scope.model.filters[0];
	      $scope.model.activeSort = $scope.model.sorts[0];
	      $rootScope.modelFilter = {
	        filter: $scope.model.activeFilter,
	        sort: $scope.model.activeSort,
	        filterText: ''
	      };
	  }

	  $scope.activateFilter = function(filter) {
		  $scope.model.activeFilter = filter;
		  $rootScope.modelFilter.filter = filter;
		  $scope.loadProcesses();
	  };

	  $scope.activateSort = function(sort) {
		  $scope.model.activeSort = sort;
		  $rootScope.modelFilter.sort = sort;
		  $scope.loadProcesses();
	  };

	  $scope.loadProcesses = function() {
		  $scope.model.loading = true;

		  var params = {
		      filter: $scope.model.activeFilter.id,
		      sort: $scope.model.activeSort.id,
		      modelType: 99
		  };

		  if ($scope.model.filterText && $scope.model.filterText != '') {
		    params.filterText = $scope.model.filterText;
		  }

		  $http({method: 'GET', url: FLOWABLE.APP_URL.getModelsUrl(), params: params}).
		  	success(function(data, status, headers, config) {
	    		$scope.model.processes = data;
	    		$scope.model.loading = false;
	        }).
	        error(function(data, status, headers, config) {
	           console.log('Something went wrong: ' + data);
	           $scope.model.loading = false;
	        });
	  };

	  var timeoutFilter = function() {
	      $scope.model.isFilterDelayed = true;
	      $timeout(function() {
	          $scope.model.isFilterDelayed = false;
	          if ($scope.model.isFilterUpdated) {
	              $scope.model.isFilterUpdated = false;
	              timeoutFilter();
	          } else {
	              $scope.model.filterText = $scope.model.pendingFilterText;
	              $rootScope.modelFilter.filterText = $scope.model.filterText;
	              $scope.loadProcesses();
	          }
	      }, 500);
	  };

	  $scope.filterDelayed = function() {
	      if ($scope.model.isFilterDelayed) {
	          $scope.model.isFilterUpdated = true;
	      } else {
	          timeoutFilter();
	      }
	  };

	  $scope.createProcess = function(mode) {
	    var modalInstance = _internalCreateModal({
	        template: 'views/custom/popup/event-flow-create.html?version=' + Date.now()
	    }, $modal, $scope);
	  };

	  $scope.importProcess = function () {
        _internalCreateModal({
            template: 'views/popup/process-import.html?version=' + Date.now()
        }, $modal, $scope);
	  };

	  $scope.showProcessDetails = function(process) {
	      if (process) {
	          $rootScope.editorHistory = [];
	          $location.path("/event-flows/" + process.id);
	      }
	  };

	  $scope.editProcessDetails = function(process) {
		  if (process) {
		      $rootScope.editorHistory = [];
            $location.path("/editor/" + process.id);
		  }
	  };

	  // Finally, load initial processes
	  $scope.loadProcesses();
}]);



angular.module('flowableModeler')
.controller('CreateNewEventFlowCtrl', ['$rootScope', '$scope', '$modal', '$http', '$location',
                                          function ($rootScope, $scope, $modal, $http, $location) {

    $scope.model = {
       loading: false,
       process: {
            name: '',
            key: '',
            description: '',
           	modelType: 99
       }
    };

    if ($scope.initialModelType !== undefined) {
        $scope.model.process.modelType = $scope.initialModelType;
    }

    $scope.ok = function () {

        if (!$scope.model.process.name || $scope.model.process.name.length == 0 ||
        	!$scope.model.process.key || $scope.model.process.key.length == 0) {
        	
            return;
        }

        $scope.model.loading = true;

        $http({method: 'POST', url: FLOWABLE.APP_URL.getModelsUrl(), data: $scope.model.process}).
            success(function(data) {
                $scope.$hide();

                $scope.model.loading = false;
                $rootScope.editorHistory = [];
                $location.path("/event-flow-editor/" + data.id);
            }).
            error(function(data, status, headers, config) {
                $scope.model.loading = false;
                $scope.model.errorMessage = data.message;
            });
    };

    $scope.cancel = function () {
        if(!$scope.model.loading) {
            $scope.$hide();
        }
    };
}]);
