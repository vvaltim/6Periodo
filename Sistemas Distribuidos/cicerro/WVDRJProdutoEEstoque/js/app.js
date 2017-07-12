angular.module("myApp", ['ngMaterial']);
//angular.module("myApp").config(function($httpProvider){
//$httpProvider.default.useXDomain = true;
//delete $httpProvider.defaults.headers.common['X-Requested-With'];
//});
angular.module("myApp").controller("myAppCtrl", function ($scope, $http, $mdDialog, $mdToast) {
    //Variaveis utilizadas
    $scope.produto = [];
    $scope.marcas = [];
    $scope.unidadesMedida = [];

    //função para projetar a posição da toas mensage
    var last = { bottom: false, top: true, left: false, right: true };
    $scope.toastPosition = angular.extend({}, last);
    $scope.getToastPosition = function () {
        sanitizePosition();
        return Object.keys($scope.toastPosition)
            .filter(function (pos) { return $scope.toastPosition[pos]; })
            .join(' ');
    };
    function sanitizePosition() {
        var current = $scope.toastPosition;
        if (current.bottom && last.top) current.top = false;
        if (current.top && last.bottom) current.bottom = false;
        if (current.right && last.left) current.left = false;
        if (current.left && last.right) current.right = false;
        last = angular.extend({}, current);
    }

    //popula os selects
    atualizarSelects();

    //função para cadastrar uma nova marca
    $scope.cadastrarMarca = function (ev) {
        //variavel definindo as propriedades do popup
        var confirm = $mdDialog.prompt()
            .title('Cadastro de Marca')
            .placeholder('Nome da Marca')
            .ariaLabel('Dog name')
            .targetEvent(ev)
            .ok('Salvar')
            .cancel('Cancelar');

        $mdDialog.show(confirm).then(function (result) {
            console.log(result);
            $http({
                method: 'POST',
                url: 'http://localhost:8080/Gestor/webresources/gestor/produto/cadastrarmarca',
                data: result,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function (data) {
                console.log(data);
                var pinTo = $scope.getToastPosition();
                $mdToast.show(
                    $mdToast.simple()
                        .textContent('Marca cadastrada com sucesso.')
                        .position(pinTo)
                        .hideDelay(5000)
                );
                atualizarSelects();
            }, function (error) {
                var pinTo = $scope.getToastPosition();
                $mdToast.show(
                    $mdToast.simple()
                        .textContent('Erro ao cadastrar uma nova marca.')
                        .position(pinTo)
                        .hideDelay(5000)
                );
            });
        }, function () {
            console.log("Cancelado");
            var pinTo = $scope.getToastPosition();
            $mdToast.show(
                $mdToast.simple()
                    .textContent('Cadastro de marca cancelado pelo usuário.')
                    .position(pinTo)
                    .hideDelay(5000)
            );
        });
    }

    //função para cadastrar uma nova unidade de medida
    $scope.cadastrarUnidadeMedida = function (ev) {
        //variavel definindo as propriedades do popup
        var confirm = $mdDialog.prompt()
            .title('Cadastro de Unidade de Medida')
            .placeholder('Nome da Marca')
            .ariaLabel('Dog name')
            .targetEvent(ev)
            .ok('Salvar')
            .cancel('Cancelar');

        $mdDialog.show(confirm).then(function (result) {
            console.log(result);
            $http({
                method: 'POST',
                url: 'http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/produto/cadastrarunidademedida',
                data: result,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function (data) {
                console.log(data);
                var pinTo = $scope.getToastPosition();
                $mdToast.show(
                    $mdToast.simple()
                        .textContent('Unidade de medida cadastrada com sucesso.')
                        .position(pinTo)
                        .hideDelay(5000)
                );
                atualizarSelects();
            }, function (error) {
                var pinTo = $scope.getToastPosition();
                $mdToast.show(
                    $mdToast.simple()
                        .textContent('Erro ao cadastrar uma nova unidade de medida.')
                        .position(pinTo)
                        .hideDelay(5000)
                );
            });
        }, function () {
            console.log("Cancelado");
            var pinTo = $scope.getToastPosition();
            $mdToast.show(
                $mdToast.simple()
                    .textContent('Cadastro de unidade de medida cancelado pelo usuário.')
                    .position(pinTo)
                    .hideDelay(5000)
            );
        });
    }

    //função para salvar os dados
    $scope.salvar = function (produto) {
        produto.marca = JSON.parse(produto.marca);
        produto.unidadeMedida = JSON.parse(produto.unidadeMedida);
        console.log(produto);
        $http({
            method: 'POST',
            url: 'http://localhost:8080/Gestor/webresources/gestor/produto/cadastrarProduto',
            data: {
                'descricao': produto.descricao,
                'valor': produto.valor,
                'marca': {'idMarca': produto.marca.idMarca,'nome': produto.marca.nome},
                'unidadeMedida': {'idUnidadeMedida': produto.unidadeMedida.idUnidadeMedida, 'nome': produto.unidadeMedida.nome}
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (data) {
            console.log(data);
            //limpa os campos
            $scope.produto = [];
        }, function (error) {
            console.log(error);
        });

    }

    //preenchendo os select com os dados do ws
    function atualizarSelects() {
        //marcas
        $http.get('http://localhost:8080/Gestor/webresources/gestor/produto/listarMarcas').then(function (data) {
            console.log(data);
            $scope.marcas = data.data;
        }, function (error) {
            console.log(error);
        });

        //unidades de medida
        $http.get('http://localhost:8080/Gestor/webresources/gestor/produto/listarunidadesmedida').then(function (data) {
            console.log(data);
            $scope.unidadesMedida = data.data;
        }, function (error) {
            console.log(error);
        });
    }
});
