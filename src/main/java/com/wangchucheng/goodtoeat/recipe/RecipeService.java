package com.wangchucheng.goodtoeat.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
   public  RecipeRepo recipeRepo;

    public List<Recipe> findAll(){
        return recipeRepo.findAll();
    }

    public boolean saveRecipe(Recipe recipe){

        if(recipe != null){
            recipe.setPosttime(new Timestamp(System.currentTimeMillis()));
            recipeRepo.save(recipe);
            return true;
        }
        return false;
    }

    //根据openid获取该用户对应的所有菜谱
    public List<Recipe> findUserRecipe(String openid){
        if(openid!=null) {
            return recipeRepo.findAllByOpenid(openid);
        }else{
            //返回所有的菜谱
            return recipeRepo.findAll();
        }
    }


    public Recipe findRecipe(Long id){
        return recipeRepo.findAllById(id);
    }

//    public List<RecommendedItem> getRecommend(Long id) throws TasteException {
//        //与数据库建立连接
//        MysqlDataSource dataSource=new MysqlDataSource();
//        dataSource.setServerName("localhost");
//        dataSource.setUser("root");
//        dataSource.setPassword("111");
//        dataSource.setDatabaseName("good_to_eat");
//        JDBCDataModel dm=new MySQLJDBCDataModel(dataSource,"Recipe","id","title","image","time");
//        DataModel model=dm;
//        UserSimilarity sim=new PearsonCorrelationSimilarity(model);
//        UserNeighborhood neighbor=new NearestNUserNeighborhood(2,sim,model);
//        Recommender rec=new GenericBooleanPrefUserBasedRecommender(model,neighbor,sim);//基于用户的推荐算法
//        List<RecommendedItem> res=rec.recommend(id,3);//根据用户1，推荐3个相似的产品
//
//        return res;
//
//
//    }

}
