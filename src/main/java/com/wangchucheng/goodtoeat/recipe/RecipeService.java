package com.wangchucheng.goodtoeat.recipe;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
   public  RecipeRepo recipeRepo;

    public boolean saveRecipe(Recipe recipe){

        if(recipe != null){
            recipeRepo.save(recipe);
            return true;
        }
        return false;
    }

    public Recipe findRecipe(Long id){
        return recipeRepo.findAllById(id);
    }

    public List<RecommendedItem> getRecommend(Long id) throws TasteException {
        //与数据库建立连接
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setUser("root");
        dataSource.setPassword("111");
        dataSource.setDatabaseName("good_to_eat");
        JDBCDataModel dm=new MySQLJDBCDataModel(dataSource,"Recipe","id","title","image","time");
        DataModel model=dm;
        UserSimilarity sim=new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighbor=new NearestNUserNeighborhood(2,sim,model);
        Recommender rec=new GenericBooleanPrefUserBasedRecommender(model,neighbor,sim);//基于用户的推荐算法
        List<RecommendedItem> res=rec.recommend(id,3);//根据用户1，推荐3个相似的产品

        return res;


    }

}
