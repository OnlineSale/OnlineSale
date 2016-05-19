//消费红利系统//////////////////////////////////////////////////////////////////////////////////////////////////////
    var tableData = null;
    function splitPage(page,pageSize,str){
            var ptable = document.getElementById("page_table");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
//清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
//设置参数
            var totalNums = tableData.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;
//向tbody中写入数据,不同页面的请求调用不同的方法
      
            //显示消费红利系统页面数据
            if(str=="consumption"){
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var date = new_tr.insertCell();
                    var balance = new_tr.insertCell();
                    var integral1 = new_tr.insertCell();
                    var integral2 = new_tr.insertCell();
                    var integral3 = new_tr.insertCell();
                    var integral4 = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var method = new_tr.insertCell();

                    date.innerHTML= tableData[i].date;
                    balance.innerHTML= tableData[i].balance;
                    integral1.innerHTML= tableData[i].integral1;
                    integral2.innerHTML= tableData[i].integral2;
                    integral3.innerHTML= tableData[i].integral3;
                    integral4.innerHTML= tableData[i].integral4;
                    state.innerHTML= tableData[i].state;


                    var content = "<button class='btn btn-default' data-toggle='modal' data-target='#myModal'><span class='glyphicon glyphicon-share'></span>分 享</button>"

                    var content2 = "<div style='float:right'>"+
                                      "<a class='btn btn-default'>重 消</a>"+
                                    "</div>";

                    method.innerHTML= content+content2;
                }
            };
            


//生成分页工具条 
            var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage("+1+","+pageSize+",'"+str+"');\">首页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
            }
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage("+(page-1)+","+pageSize+",'"+str+"');\">上一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage("+(page+1)+","+pageSize+",'"+str+"');\">下一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage("+(totalPage)+","+pageSize+",'"+str+"');\">尾页</a></li> ";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
            }
            document.getElementById("page_bar").innerHTML = pageBar;
        }


//创业积分系统//////////////////////////////////////////////////////////////////////////////////////////////////////
        var tableData1 = null;
        function splitPage1(page,pageSize){
            var ptable = document.getElementById("page_table1");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
//清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
//设置参数
            var totalNums = tableData1.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;
//向tbody中写入数据,不同页面的请求调用不同的方法
      
            //显示创业积分系统页面数据
            //if(str=="entrepreneurship"){
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var date = new_tr.insertCell();
                    var balance = new_tr.insertCell();
                    var integral1 = new_tr.insertCell();
                    var state = new_tr.insertCell();
                    var method = new_tr.insertCell();

                    date.innerHTML= tableData1[i].date;
                    balance.innerHTML= tableData1[i].balance;
                    integral1.innerHTML= tableData1[i].integral1;
                    state.innerHTML= tableData1[i].state;

                    var content = "<a class='btn btn-default'>重 消</a>";

                    method.innerHTML = content;
                //}
            };
            
//生成分页工具条 
            var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage1("+1+","+pageSize+");\">首页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
            }
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage1("+(page-1)+","+pageSize+");\">上一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage1("+(page+1)+","+pageSize+");\">下一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage1("+(totalPage)+","+pageSize+");\">尾页</a></li> ";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
            }
            document.getElementById("page_bar1").innerHTML = pageBar;
        }


//请我代付系统//////////////////////////////////////////////////////////////////////////////////////////////////////
        var tableData2 = null;
        function splitPage2(page,pageSize){
            var ptable = document.getElementById("page_table2");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
//清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
//设置参数
            var totalNums = tableData2.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;
//向tbody中写入数据,不同页面的请求调用不同的方法
      
            //显示请我代付系统页面数据
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var username = new_tr.insertCell();
                    var order_ID = new_tr.insertCell();
                    var money = new_tr.insertCell();
                    var method = new_tr.insertCell();

                    username.innerHTML= tableData2[i].username;
                    order_ID.innerHTML= tableData2[i].order_ID;
                    money.innerHTML= tableData2[i].money;

                    var content = "<a class='btn btn-default'><span class='glyphicon glyphicon-send'></span> 支 付</a>";
                    method.innerHTML = content;
            };
            
//生成分页工具条 
            var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage2("+1+","+pageSize+");\">首页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
            }
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage2("+(page-1)+","+pageSize+");\">上一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage2("+(page+1)+","+pageSize+");\">下一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage2("+(totalPage)+","+pageSize+");\">尾页</a></li> ";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
            }
            document.getElementById("page_bar2").innerHTML = pageBar;
        }
//提现记录系统//////////////////////////////////////////////////////////////////////////////////////////////////////
        var tableData3 = null;
        function splitPage3(page,pageSize){
            var ptable = document.getElementById("page_table3");
            var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成  
//清除tbody 
            for(var i=num-1;i>0;i--){
                ptable.deleteRow(i);
            }
//设置参数
            var totalNums = tableData3.length;//总行数 
            var totalPage = Math.ceil(totalNums/pageSize);//总页数 
            var begin = (page-1)*pageSize;;//页起始位置(包括) 
            var end = page*pageSize;//页结束位置 
            end = end>totalNums?totalNums:end;
//向tbody中写入数据,不同页面的请求调用不同的方法
      
            //显示请我代付系统页面数据
                for(var i=begin;i<end;i++){
                    var new_tr = ptable.insertRow();

                    var takeIntegral = new_tr.insertCell();
                    var takeMoney = new_tr.insertCell();
                    var date = new_tr.insertCell();
                    var card_ID = new_tr.insertCell();

                    takeIntegral.innerHTML= tableData3[i].takeIntegral;
                    takeMoney.innerHTML= tableData3[i].takeMoney;
                    date.innerHTML= tableData3[i].date;
                    card_ID.innerHTML = tableData3[i].card_ID;
            };
            
//生成分页工具条 
            var pageBar = "<span style='padding-left:10px;height:35px;line-height:35px;' class='text-muted'>共"+totalNums+"条第<span class='text-danger'>"+page+"</span>页/共"+totalPage+"页 </span>";
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage3("+1+","+pageSize+");\">首页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">首页</a> </li> ";
            }
            if(page>1){
                pageBar += "<li><a href=\"javascript:splitPage3("+(page-1)+","+pageSize+");\">上一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">上一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage3("+(page+1)+","+pageSize+");\">下一页</a> </li>";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">下一页</a> </li> ";
            }
            if(page<totalPage){
                pageBar += "<li><a href=\"javascript:splitPage3("+(totalPage)+","+pageSize+");\">尾页</a></li> ";
            }else{
                pageBar += "<li><a href=\"javascript:void(0);\">尾页</a> </li> ";
            }
            document.getElementById("page_bar3").innerHTML = pageBar;
        }