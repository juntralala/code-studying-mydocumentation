import pandas as pd
from sklearn.model_selection import train_test_split

data = pd.read_csv("./sample_data/california_housing_train.csv")
x = data.drop(columns=["median_house_value"])
y = data["median_house_value"]
x_train,x_test, y_train, y_test = train_test_split(x, y, test_size=0.2,random_state=42)

from sklearn.linear_model import Lars
lars_model = Lars()
lars_model.fit(x_train, y_train)

from sklearn.linear_model import LinearRegression
linear_model = LinearRegression()
linear_model.fit(x_train, y_train)

from sklearn.ensemble import GradientBoostingRegressor
gbr_model = GradientBoostingRegressor()
gbr_model.fit(x_train, y_train)

print(f"""
Lars: {lars_model.score(x_test, y_test)}
Linear: {linear_model.score(x_test, y_test)}
GBR: {gbr_model.score(x_test, y_test)}
""")