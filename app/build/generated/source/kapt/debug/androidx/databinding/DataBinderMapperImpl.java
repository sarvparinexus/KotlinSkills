package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new kotlins.skills.remember.DataBinderMapperImpl());
  }
}
