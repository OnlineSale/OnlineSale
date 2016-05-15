//消费记录系统//////////////////////////////////////////////////////////////////////////////////////////////////////

//消费未支付订单系统//////////////////////////////////////////////////////////////////////////////////////////////////////
var data = null;
function splitPage4UnpaidRecord(page,pageSize,str){
    var ptable = document.getElementById("page_table");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
//清除tbody 
for(var i=num-1;i>0;i--){
    ptable.deleteRow(i);
}
//设置参数
            var totalNums = data.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;
//向tbody中写入数据,不同页面的请求调用不同的方法

            //显示未付款订单系统页面数据
            for(var i=begin;i<end;i++){
                var new_tr_orderId = ptable.insertRow();
                new_tr_orderId.className="tr_style"

                var order_ID = new_tr_orderId.insertCell();
                var order_ID1 = new_tr_orderId.insertCell();
                var order_ID2 = new_tr_orderId.insertCell();
                var order_ID3 = new_tr_orderId.insertCell();
                var order_ID4 = new_tr_orderId.insertCell();
                var method = new_tr_orderId.insertCell();
                method.innerHTML= "<a class='btn btn-default'>去付款</a>";
                var length = data[i].content.length;
                order_ID.innerHTML = "<h4 >订单号："+data[i].order_ID;
                for (var j = 0; j < length; j++) {

                    var new_tr = ptable.insertRow();

                    var img = new_tr.insertCell();
                    var perPriceAndNum = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var orderTime = new_tr.insertCell();
                    var PaidMoney = new_tr.insertCell();
                    var method = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                    +"<div class='row'>"
                    +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                    +"<div class='col-md-6 text-left'>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data[i].content[j].name+"</div>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data[i].content[j].style;+"</div>"
                    +"</div>"
                    +"</div>"
                    +"</div>"

                    var content2 = "<div class='container-fluid'>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data[i].content[j].perPrice+"元</div>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data[i].content[j].number+"件</div>"
                    +"</div>"

                    img.innerHTML= content;
                    perPriceAndNum.innerHTML= content2;
                    state.innerHTML= data[i].content[j].state;
                    orderTime.innerHTML= data[i].content[j].orderTime;
                    PaidMoney.innerHTML= data[i].content[j].PaidMoney;
                }

            };
            


//生成分页工具条 
            var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage4UnpaidRecord("+1+","+pageSize+");\">首页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
            }
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage4UnpaidRecord("+(page-1)+","+pageSize+");\">上一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage4UnpaidRecord("+(page+1)+","+pageSize+");\">下一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage4UnpaidRecord("+(totalPage)+","+pageSize+");\">尾页</a></li> ";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
            }
            document.getElementById("page_bar").innerHTML = pageBar;
}

//消费未发货订单系统//////////////////////////////////////////////////////////////////////////////////////////////////////
    var data1 = null;
    function splitPage4ConsumRecord(page,pageSize,state){
        //显示未发货订单系统页面数据，根据不同状态显示
        if(state == 1){
            var ptable = document.getElementById("page_table1");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
            //清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
            //设置参数
            var totalNums = data1.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;


            //向tbody中写入数据
            for(var i=begin;i<end;i++){
                var new_tr_orderId = ptable.insertRow();
                new_tr_orderId.className="tr_style"

                var order_ID = new_tr_orderId.insertCell();
                var order_ID1 = new_tr_orderId.insertCell();
                var order_ID2 = new_tr_orderId.insertCell();
                var order_ID3 = new_tr_orderId.insertCell();
                var order_ID4 = new_tr_orderId.insertCell();
                var method = new_tr_orderId.insertCell();
                method.innerHTML= "<a class='btn btn-default'>催 单</a>";
                var length = data[i].content.length;
                order_ID.innerHTML = "<h4 >订单号："+data[i].order_ID;
                for (var j = 0; j < length; j++) {

                    var new_tr = ptable.insertRow();

                    var img = new_tr.insertCell();
                    var perPriceAndNum = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var orderTime = new_tr.insertCell();
                    var PaidMoney = new_tr.insertCell();
                    var method = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                    +"<div class='row'>"
                    +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                    +"<div class='col-md-6 text-left'>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data1[i].content[j].name+"</div>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data1[i].content[j].style;+"</div>"
                    +"</div>"
                    +"</div>"
                    +"</div>"

                    var content2 = "<div class='container-fluid'>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data1[i].content[j].perPrice+"元</div>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data1[i].content[j].number+"件</div>"
                    +"</div>"

                    img.innerHTML= content;
                    perPriceAndNum.innerHTML= content2;
                    state.innerHTML= data1[i].content[j].state;
                    orderTime.innerHTML= data1[i].content[j].orderTime;
                    PaidMoney.innerHTML= data1[i].content[j].PaidMoney;
                };

            };
            //表格数据写入完成
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+1+","+pageSize+","+1+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(page-1)+","+pageSize+","+1+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(page+1)+","+pageSize+","+1+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(totalPage)+","+pageSize+","+1+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar1").innerHTML = pageBar;
            };

//消费已发货订单系统//////////////////////////////////////////////////////////////////////////////////////////////////////
            if(state == 2){
                var ptable = document.getElementById("page_table2");
                var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
                //清除tbody 
                for(var i=num-1;i>0;i--){
                    ptable.deleteRow(i);
                }
                //设置参数
                var totalNums = data1.length;//总行数 
                var totalPage = Math.ceil(totalNums/pageSize);//总页数 
                var begin = (page-1)*pageSize;;//页起始位置(包括) 
                var end = page*pageSize;//页结束位置 
                end = end>totalNums?totalNums:end;

                for(var i=begin;i<end;i++){
                    var new_tr_orderId = ptable.insertRow();
                    new_tr_orderId.className="tr_style"

                    var order_ID = new_tr_orderId.insertCell();
                    var order_ID1 = new_tr_orderId.insertCell();
                    var order_ID2 = new_tr_orderId.insertCell();
                    var order_ID3 = new_tr_orderId.insertCell();
                    var order_ID4 = new_tr_orderId.insertCell();
                    var method = new_tr_orderId.insertCell();
                    method.innerHTML= "<a class='btn btn-default'>查看物流</a>";
                    var length = data[i].content.length;
                    order_ID.innerHTML = "<h4 >订单号："+data[i].order_ID;
                    for (var j = 0; j < length; j++) {

                        var new_tr = ptable.insertRow();

                        var img = new_tr.insertCell();
                        var perPriceAndNum = new_tr.insertCell();
                        var state = new_tr.insertCell();
                        var orderTime = new_tr.insertCell();
                        var PaidMoney = new_tr.insertCell();
                        var method = new_tr.insertCell();

                        var content = "<div class='container-fluid'>"
                                    +"<div class='row'>"
                                        +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                                        +"<div class='col-md-6 text-left'>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data1[i].content[j].name+"</div>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data1[i].content[j].style;+"</div>"
                                        +"</div>"
                                    +"</div>"
                                +"</div>"

                         var content2 = "<div class='container-fluid'>"
                                        +"<div class='row text-center' style='height:25px;line-height:25px'>"+data1[i].content[j].perPrice+"元</div>"
                                        +"<div class='row text-center' style='height:25px;line-height:25px'>"+data1[i].content[j].number+"件</div>"
                                  +"</div>"

                        img.innerHTML= content;
                        perPriceAndNum.innerHTML= content2;
                        state.innerHTML= data1[i].content[j].state;
                        orderTime.innerHTML= data1[i].content[j].orderTime;
                        PaidMoney.innerHTML= data1[i].content[j].PaidMoney;
                    };

                };
            
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+1+","+pageSize+","+2+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(page-1)+","+pageSize+","+2+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(page+1)+","+pageSize+","+2+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(totalPage)+","+pageSize+","+2+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar2").innerHTML = pageBar;

            };
//消费待收货订单系统//////////////////////////////////////////////////////////////////////////////////////////////////////
            if(state == 3){
                var ptable = document.getElementById("page_table3");
                var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
                //清除tbody 
                for(var i=num-1;i>0;i--){
                    ptable.deleteRow(i);
                }
                //设置参数
                var totalNums = data1.length;//总行数 
                var totalPage = Math.ceil(totalNums/pageSize);//总页数 
                var begin = (page-1)*pageSize;;//页起始位置(包括) 
                var end = page*pageSize;//页结束位置 
                end = end>totalNums?totalNums:end;

                for(var i=begin;i<end;i++){
                    var new_tr_orderId = ptable.insertRow();
                    new_tr_orderId.className="tr_style";

                    var order_ID = new_tr_orderId.insertCell();
                    var order_ID1 = new_tr_orderId.insertCell();
                    var order_ID2 = new_tr_orderId.insertCell();
                    var order_ID3 = new_tr_orderId.insertCell();
                    var method = new_tr_orderId.insertCell();
                    method.setAttribute('colspan','2');
                    method.innerHTML= "<a class='btn btn-default'>查看物流</a><a class='btn btn-default'>确认收货</a>";
                    var length = data[i].content.length;
                    order_ID.innerHTML = "<h4 >订单号："+data[i].order_ID;
                    for (var j = 0; j < length; j++) {

                        var new_tr = ptable.insertRow();

                        var img = new_tr.insertCell();
                        var perPriceAndNum = new_tr.insertCell();
                        var state = new_tr.insertCell();
                        var orderTime = new_tr.insertCell();
                        var PaidMoney = new_tr.insertCell();
                        var method = new_tr.insertCell();

                        var content = "<div class='container-fluid'>"
                                    +"<div class='row'>"
                                        +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                                        +"<div class='col-md-6 text-left'>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data1[i].content[j].name+"</div>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data1[i].content[j].style;+"</div>"
                                        +"</div>"
                                    +"</div>"
                                +"</div>"

                         var content2 = "<div class='container-fluid'>"
                                        +"<div class='row text-center' style='height:25px;line-height:25px'>"+data1[i].content[j].perPrice+"元</div>"
                                        +"<div class='row text-center' style='height:25px;line-height:25px'>"+data1[i].content[j].number+"件</div>"
                                  +"</div>"

                        img.innerHTML= content;
                        perPriceAndNum.innerHTML= content2;
                        state.innerHTML= data1[i].content[j].state;
                        orderTime.innerHTML= data1[i].content[j].orderTime;
                        PaidMoney.innerHTML= data1[i].content[j].PaidMoney;
                    };

                };
            
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+1+","+pageSize+","+3+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(page-1)+","+pageSize+","+3+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(page+1)+","+pageSize+","+3+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(totalPage)+","+pageSize+","+3+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar3").innerHTML = pageBar;

            };
    //消费待收货订单系统//////////////////////////////////////////////////////////////////////////////////////////////////////
            if(state == 4){
                var ptable = document.getElementById("page_table4");
                var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
                //清除tbody 
                for(var i=num-1;i>0;i--){
                    ptable.deleteRow(i);
                }
                //设置参数
                var totalNums = data1.length;//总行数 
                var totalPage = Math.ceil(totalNums/pageSize);//总页数 
                var begin = (page-1)*pageSize;;//页起始位置(包括) 
                var end = page*pageSize;//页结束位置 
                end = end>totalNums?totalNums:end;

                for(var i=begin;i<end;i++){
                    var new_tr_orderId = ptable.insertRow();
                    new_tr_orderId.className="tr_style";

                    var order_ID = new_tr_orderId.insertCell();
                    //填充作用
                    var order_ID1 = new_tr_orderId.insertCell();
                    var order_ID2 = new_tr_orderId.insertCell();
                    var order_ID3 = new_tr_orderId.insertCell();
                    var order_ID4 = new_tr_orderId.insertCell();
                    var method = new_tr_orderId.insertCell();
                    method.innerHTML= "<a class='btn btn-default'>去评价</a>";
                    var length = data[i].content.length;
                    order_ID.innerHTML = "<h4 >订单号："+data[i].order_ID;
                    for (var j = 0; j < length; j++) {

                        var new_tr = ptable.insertRow();

                        var img = new_tr.insertCell();
                        var perPriceAndNum = new_tr.insertCell();
                        var state = new_tr.insertCell();
                        var orderTime = new_tr.insertCell();
                        var PaidMoney = new_tr.insertCell();
                        var method = new_tr.insertCell();

                        var content = "<div class='container-fluid'>"
                                    +"<div class='row'>"
                                        +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                                        +"<div class='col-md-6 text-left'>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data1[i].content[j].name+"</div>"
                                            +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data1[i].content[j].style;+"</div>"
                                        +"</div>"
                                    +"</div>"
                                +"</div>"

                         var content2 = "<div class='container-fluid'>"
                                        +"<div class='row text-center' style='height:25px;line-height:25px'>"+data1[i].content[j].perPrice+"元</div>"
                                        +"<div class='row text-center' style='height:25px;line-height:25px'>"+data1[i].content[j].number+"件</div>"
                                  +"</div>"

                        img.innerHTML= content;
                        perPriceAndNum.innerHTML= content2;
                        state.innerHTML= data1[i].content[j].state;
                        orderTime.innerHTML= data1[i].content[j].orderTime;
                        PaidMoney.innerHTML= data1[i].content[j].PaidMoney;
                    };

                };
            
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+1+","+pageSize+","+4+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(page-1)+","+pageSize+","+4+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(page+1)+","+pageSize+","+4+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ConsumRecord("+(totalPage)+","+pageSize+","+4+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar4").innerHTML = pageBar;

            };
            
}

//换货未发货订单系统//////////////////////////////////////////////////////////////////////////////////////////////////////
    var data2 = null;
    function splitPage4ChangeGoodsRecord(page,pageSize,state){
        //显示未付款订单系统页面数据，根据不同状态显示
        if(state == 5){
            var ptable = document.getElementById("page_table5");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
            //清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
            //设置参数
            var totalNums = data2.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;


            //向tbody中写入数据
            for(var i=begin;i<end;i++){
                var new_tr_orderId = ptable.insertRow();
                new_tr_orderId.className="tr_style"

                var order_ID = new_tr_orderId.insertCell();
                var order_ID1 = new_tr_orderId.insertCell();
                var order_ID2 = new_tr_orderId.insertCell();
                var order_ID3 = new_tr_orderId.insertCell();
                var order_ID4 = new_tr_orderId.insertCell();
                var order_ID5 = new_tr_orderId.insertCell();
                var method = new_tr_orderId.insertCell();
                method.innerHTML= "<a class='btn btn-default'>去付款</a>";
                var length = data2[i].content.length;
                order_ID.innerHTML = "<h4 >订单号："+data2[i].order_ID;
                for (var j = 0; j < length; j++) {

                    var new_tr = ptable.insertRow();

                    var img = new_tr.insertCell();
                    var perPriceAndNum = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var changeTime = new_tr.insertCell();
                    var changeGoods = new_tr.insertCell();
                    var integral = new_tr.insertCell();
                    var method2 = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                    +"<div class='row'>"
                    +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                    +"<div class='col-md-6 text-left'>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data2[i].content[j].name+"</div>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data2[i].content[j].style;+"</div>"
                    +"</div>"
                    +"</div>"
                    +"</div>"

                    var content2 = "<div class='container-fluid'>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].perPrice+"元</div>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].number+"件</div>"
                    +"</div>"

                    img.innerHTML= content;
                    perPriceAndNum.innerHTML= content2;
                    state.innerHTML= data2[i].content[j].state;
                    changeTime.innerHTML= data2[i].content[j].changeTime;
                    changeGoods.innerHTML = data2[i].content[j].changeGoods;
                    integral.innerHTML= data2[i].content[j].integral;
                };

            };
            //表格数据写入完成
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+1+","+pageSize+","+5+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page-1)+","+pageSize+","+5+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page+1)+","+pageSize+","+5+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(totalPage)+","+pageSize+","+5+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar5").innerHTML = pageBar;
            };

//显示未发货订单系统页面数据，根据不同状态显示
        if(state == 6){
            var ptable = document.getElementById("page_table6");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
            //清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
            //设置参数
            var totalNums = data2.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;


            //向tbody中写入数据
            for(var i=begin;i<end;i++){
                var new_tr_orderId = ptable.insertRow();
                new_tr_orderId.className="tr_style"

                var order_ID = new_tr_orderId.insertCell();
                var order_ID1 = new_tr_orderId.insertCell();
                var order_ID2 = new_tr_orderId.insertCell();
                var order_ID3 = new_tr_orderId.insertCell();
                var order_ID4 = new_tr_orderId.insertCell();
                var order_ID5 = new_tr_orderId.insertCell();
                var method = new_tr_orderId.insertCell();
                method.innerHTML= "<a class='btn btn-default'>催 单</a>";
                var length = data2[i].content.length;
                order_ID.innerHTML = "<h4 >订单号："+data2[i].order_ID;
                for (var j = 0; j < length; j++) {

                    var new_tr = ptable.insertRow();

                    var img = new_tr.insertCell();
                    var perPriceAndNum = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var changeTime = new_tr.insertCell();
                    var changeGoods = new_tr.insertCell();
                    var integral = new_tr.insertCell();
                    var method2 = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                    +"<div class='row'>"
                    +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                    +"<div class='col-md-6 text-left'>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data2[i].content[j].name+"</div>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data2[i].content[j].style;+"</div>"
                    +"</div>"
                    +"</div>"
                    +"</div>"

                    var content2 = "<div class='container-fluid'>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].perPrice+"元</div>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].number+"件</div>"
                    +"</div>"

                    img.innerHTML= content;
                    perPriceAndNum.innerHTML= content2;
                    state.innerHTML= data2[i].content[j].state;
                    changeTime.innerHTML= data2[i].content[j].changeTime;
                    changeGoods.innerHTML = data2[i].content[j].changeGoods;
                    integral.innerHTML= data2[i].content[j].integral;
                };

            };
            //表格数据写入完成
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+1+","+pageSize+","+6+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page-1)+","+pageSize+","+6+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page+1)+","+pageSize+","+6+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(totalPage)+","+pageSize+","+6+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar6").innerHTML = pageBar;
            };

//显示已发货订单系统页面数据，根据不同状态显示
        if(state == 7){
            var ptable = document.getElementById("page_table7");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
            //清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
            //设置参数
            var totalNums = data2.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;


            //向tbody中写入数据
            for(var i=begin;i<end;i++){
                var new_tr_orderId = ptable.insertRow();
                new_tr_orderId.className="tr_style"

                var order_ID = new_tr_orderId.insertCell();
                var order_ID1 = new_tr_orderId.insertCell();
                var order_ID2 = new_tr_orderId.insertCell();
                var order_ID3 = new_tr_orderId.insertCell();
                var order_ID4 = new_tr_orderId.insertCell();
                var order_ID5 = new_tr_orderId.insertCell();
                var method = new_tr_orderId.insertCell();
                method.innerHTML= "<a class='btn btn-default'>查看物流</a>";
                var length = data2[i].content.length;
                order_ID.innerHTML = "<h4 >订单号："+data2[i].order_ID;
                for (var j = 0; j < length; j++) {

                    var new_tr = ptable.insertRow();

                    var img = new_tr.insertCell();
                    var perPriceAndNum = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var changeTime = new_tr.insertCell();
                    var changeGoods = new_tr.insertCell();
                    var integral = new_tr.insertCell();
                    var method2 = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                    +"<div class='row'>"
                    +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                    +"<div class='col-md-6 text-left'>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data2[i].content[j].name+"</div>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data2[i].content[j].style;+"</div>"
                    +"</div>"
                    +"</div>"
                    +"</div>"

                    var content2 = "<div class='container-fluid'>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].perPrice+"元</div>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].number+"件</div>"
                    +"</div>"

                    img.innerHTML= content;
                    perPriceAndNum.innerHTML= content2;
                    state.innerHTML= data2[i].content[j].state;
                    changeTime.innerHTML= data2[i].content[j].changeTime;
                    changeGoods.innerHTML = data2[i].content[j].changeGoods;
                    integral.innerHTML= data2[i].content[j].integral;
                };

            };
            //表格数据写入完成
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+1+","+pageSize+","+7+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page-1)+","+pageSize+","+7+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page+1)+","+pageSize+","+7+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(totalPage)+","+pageSize+","+7+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar7").innerHTML = pageBar;
            };

     //显示待收货订单系统页面数据，根据不同状态显示
        if(state == 8){
            var ptable = document.getElementById("page_table8");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
            //清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
            //设置参数
            var totalNums = data2.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;


            //向tbody中写入数据
            for(var i=begin;i<end;i++){
                var new_tr_orderId = ptable.insertRow();
                new_tr_orderId.className="tr_style"

                var order_ID = new_tr_orderId.insertCell();
                var order_ID1 = new_tr_orderId.insertCell();
                var order_ID2 = new_tr_orderId.insertCell();
                var order_ID3 = new_tr_orderId.insertCell();
                var order_ID4 = new_tr_orderId.insertCell();
                var method = new_tr_orderId.insertCell();
                method.setAttribute("colspan","2");
                method.innerHTML= "<a class='btn btn-default'>查看物流</a><a class='btn btn-default'>确认收货</a>";
                var length = data2[i].content.length;
                order_ID.innerHTML = "<h4 >订单号："+data2[i].order_ID;
                for (var j = 0; j < length; j++) {

                    var new_tr = ptable.insertRow();

                    var img = new_tr.insertCell();
                    var perPriceAndNum = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var changeTime = new_tr.insertCell();
                    var changeGoods = new_tr.insertCell();
                    var integral = new_tr.insertCell();
                    var method2 = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                    +"<div class='row'>"
                    +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                    +"<div class='col-md-6 text-left'>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data2[i].content[j].name+"</div>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data2[i].content[j].style;+"</div>"
                    +"</div>"
                    +"</div>"
                    +"</div>"

                    var content2 = "<div class='container-fluid'>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].perPrice+"元</div>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].number+"件</div>"
                    +"</div>"

                    img.innerHTML= content;
                    perPriceAndNum.innerHTML= content2;
                    state.innerHTML= data2[i].content[j].state;
                    changeTime.innerHTML= data2[i].content[j].changeTime;
                    changeGoods.innerHTML = data2[i].content[j].changeGoods;
                    integral.innerHTML= data2[i].content[j].integral;
                };

            };
            //表格数据写入完成
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+1+","+pageSize+","+8+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page-1)+","+pageSize+","+8+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page+1)+","+pageSize+","+8+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(totalPage)+","+pageSize+","+8+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar8").innerHTML = pageBar;
            };

    //显示已完成订单系统页面数据，根据不同状态显示
        if(state == 9){
            var ptable = document.getElementById("page_table9");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
            //清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
            //设置参数
            var totalNums = data2.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;


            //向tbody中写入数据
            for(var i=begin;i<end;i++){
                var new_tr_orderId = ptable.insertRow();
                new_tr_orderId.className="tr_style"

                var order_ID = new_tr_orderId.insertCell();
                var order_ID1 = new_tr_orderId.insertCell();
                var order_ID2 = new_tr_orderId.insertCell();
                var order_ID3 = new_tr_orderId.insertCell();
                var order_ID4 = new_tr_orderId.insertCell();
                var order_ID5 = new_tr_orderId.insertCell();
                var method = new_tr_orderId.insertCell();
                method.innerHTML= "<a class='btn btn-default'>去评价</a>";
                var length = data2[i].content.length;
                order_ID.innerHTML = "<h4 >订单号："+data2[i].order_ID;
                for (var j = 0; j < length; j++) {

                    var new_tr = ptable.insertRow();

                    var img = new_tr.insertCell();
                    var perPriceAndNum = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var changeTime = new_tr.insertCell();
                    var changeGoods = new_tr.insertCell();
                    var integral = new_tr.insertCell();
                    var method2 = new_tr.insertCell();

                    var content = "<div class='container-fluid'>"
                    +"<div class='row'>"
                    +"<div class='col-md-6 text-right'><img style='width:50px;height:50px;' alt='此处应有图片' src='../images/goods.png'/></div>"
                    +"<div class='col-md-6 text-left'>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>名称："+data2[i].content[j].name+"</div>"
                    +"<div class='row text-left' style='height:25px;line-height:25px'>规格："+data2[i].content[j].style;+"</div>"
                    +"</div>"
                    +"</div>"
                    +"</div>"

                    var content2 = "<div class='container-fluid'>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].perPrice+"元</div>"
                    +"<div class='row text-center' style='height:25px;line-height:25px'>"+data2[i].content[j].number+"件</div>"
                    +"</div>"

                    img.innerHTML= content;
                    perPriceAndNum.innerHTML= content2;
                    state.innerHTML= data2[i].content[j].state;
                    changeTime.innerHTML= data2[i].content[j].changeTime;
                    changeGoods.innerHTML = data2[i].content[j].changeGoods;
                    integral.innerHTML= data2[i].content[j].integral;
                };

            };
            //表格数据写入完成
                //生成分页工具条 
                var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+1+","+pageSize+","+9+");\">首页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
                }
                if(page>1){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page-1)+","+pageSize+","+9+");\">上一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(page+1)+","+pageSize+","+9+");\">下一页</a> </li>";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
                }
                if(page<totalPage){
                    pageBar += "<li><a href=\"javascript:splitPage4ChangeGoodsRecord("+(totalPage)+","+pageSize+","+9+");\">尾页</a></li> ";
                }else{
                    pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
                }
                document.getElementById("page_bar9").innerHTML = pageBar;
            };
}