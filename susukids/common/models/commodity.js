'use strict';

module.exports = function(Commodity) {

       // remote method (Product Name)
       Commodity.remoteMethod(
        'getCategoryName',
        {
            description: 'get category name',
            accepts: [
                { arg: 'nameCategory', type: 'string'}
            ],
            returns:{
                arg: 'res', type:'object', root: true
            },
            http: { path: '/getCategoryName', verb: 'get' }
        }
    );

    Commodity.getCategoryName = function(nameCategory, callback){
        new Promise(function(resolve, reject){
            var filter = {
                where: {
                    nameCategory : {
                        like : nameCategory
                    }
                }
            }
            Commodity.find(filter, function(err, result){
                if(err) reject (err)
                if(result === null){
                    err = new Error ("Nama Category Tidak Dapat Ditemukan")
                    err.statusCode = 404
                    reject (err)
                }
                resolve(result)
            })
        }).then(function(res){
            if (!res) callback (err)
            return callback (null, res)
        }).catch(function(err){
            callback(err);
        });
    }
    
//-----------------------------------------------------//
//-----------------------------------------------------//
//-----------------------------------------------------//

// remote method (Category)
Commodity.remoteMethod(
    'getCategory',
    {
        description: 'get category',
        accepts: [
            { arg: 'category', type: 'string'}
        ],
        returns:{
            arg: 'res', type:'object', root: true
        },
        http: { path: '/getCategory', verb: 'get' }
    }
);

Commodity.getCategory = function(Category, callback){
    new Promise(function(resolve, reject){
        var filter = {
            where: {
                Category : {
                    like : Category
                }
            }
        }
        Commodity.find(filter, function(err, result){
            if(err) reject (err)
            if(result === null){
                err = new Error ("Category Tidak Dapat Ditemukan")
                err.statusCode = 404
                reject (err)
            }
            resolve(result)
        })
    }).then(function(res){
        if (!res) callback (err)
        return callback (null, res)
    }).catch(function(err){
        callback(err);
    });
}

//-----------------------------------------------------//
//-----------------------------------------------------//
//-----------------------------------------------------//

// remote method (find By ID)
Commodity.remoteMethod(
    'getID',
    {
        description: 'get ID',
        accepts: [
            { arg: 'id', type: 'string'}
        ],
        returns:{
            arg: 'res', type:'object', root: true
        },
        http: { path: '/getID', verb: 'get' }
    }
);

Commodity.getID = function(id, callback){
    new Promise(function(resolve, reject){
        Commodity.findById(id, function(err, result){
            if(err) reject (err)
            if(result === null){
                err = new Error ("Id Tidak Dapat Ditemukan")
                err.statusCode = 404
                reject (err)
            }
            resolve(result)
        })
    }).then(function(res){
        if (!res) callback (err)
        return callback (null, res)
    }).catch(function(err){
        callback(err);
    });
}
};
