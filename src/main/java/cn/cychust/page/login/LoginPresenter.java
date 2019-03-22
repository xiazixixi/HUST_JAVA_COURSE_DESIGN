package cn.cychust.page.login;

import cn.cychust.base.BasePresenterImpl;
import cn.cychust.data.tbrxx.T_BRXX;
import cn.cychust.data.tbrxx.source.TBRXXDataSource;
import cn.cychust.data.tbrxx.source.TBRXXRepository;

/**
 * @program: hospital-manager-system
 * @description: login presenter
 * @author: Yichao Chen
 * @create: 2019-03-15 16:21
 **/
public class LoginPresenter extends BasePresenterImpl implements LoginContract.Presenter {
    private LoginContract.View mView;
    private TBRXXDataSource mTBRXXDataSource;

    public LoginPresenter(LoginContract.View view, TBRXXDataSource TBRXXDataSource) {
        mView = view;
        mTBRXXDataSource = TBRXXDataSource;
        mView.setPresenter(this);
    }

    public void login(String user, String pass) {
        TBRXXDataSource.getINSTANCE().getOne(user, pass, new TBRXXRepository.GetTbrxxCallback() {
            @Override
            public void onTasksLoaded(T_BRXX t_brxx) {

            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    public void register() {
        //todo register 界面
        mView.loginSuccess();
    }

}
